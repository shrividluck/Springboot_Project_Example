/**
 * 
 */
/**
 * @author shrividluck
 *
 */
package com.shri.mtts.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.shri.mtts.entity.Movie;
import com.shri.mtts.entity.impl.MovieImpl;
import com.shri.mtts.externalresource.TheaterServiceClient;
import com.shri.mtts.repository.MovieRepository;
import com.shri.mtts.service.MovieService;
import com.shri.mtts.service.exception.ErrorCode;
import com.shri.mtts.service.exception.InvalidFieldException;
import com.shri.mtts.service.exception.MTTSException;


@Service
public class MovieServiceImpl implements MovieService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MovieRepository mRepository;

	@Autowired
	private TheaterServiceClient theaterServiceClient;


	@Override
	public Movie addMovie(Movie movie) {
		boolean isMinT = false;
		if( movie.getMovieName() == null){
			throw new InvalidFieldException("Name is required");
		}
		logger.info("Calling theater Service for movieName "+movie.getMovieName());
		if(theaterServiceClient.theaterIsRunningMovie(movie.getMovieName())) {
			logger.info("Theater is running it !!!");
			isMinT = true;
		} else {
			logger.info("Theater is not running it !!!");
		}
		MovieImpl impl = mRepository.findByMovieName(movie.getMovieName());	
		if((impl != null) && (isMinT == impl.isMovieInTheater())) {
			logger.info("Found in dB !!!");
			return impl;
		}		
		impl = (MovieImpl) movie;
		impl.setMovieInTheater(isMinT);
		return mRepository.save(impl);
	}


	@Override
	public Movie updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		if( movie.getMovieName() == null){
			throw new InvalidFieldException("Name is required");
		}
		MovieImpl impl = mRepository.findByMovieName(movie.getMovieName());	
		if(impl != null) {
			return impl;
		}
		impl = (MovieImpl) movie;
		return mRepository.save(impl);
	}

	@Override
	public MovieImpl getMovie(String string) {
		if( string == null){
			throw new InvalidFieldException("Name is required");
		}

		MovieImpl found =  mRepository.findByMovieName(string);	
		if(found==null){
			throw new MTTSException(ErrorCode.NOT_FOUND, "Movie not found");
		}
		return found;
	}




	@Override
	public Iterable<MovieImpl> getAllMovies() {
		Iterable<MovieImpl> mList = mRepository.findAll();	
		if (mList == null) {
			throw new MTTSException(ErrorCode.NOT_FOUND, "No movies found");
		}
		return mList;
	}
	@Override
	public Iterable<MovieImpl> getMoviesByGenre(String gen) {
		if(StringUtils.isEmpty(gen)) {
			throw new MTTSException(ErrorCode.MISSING_DATA, "genre is required");
		}
		Iterable<MovieImpl> mList = mRepository.findByGenreContaining(gen);
		if (mList == null) {
			throw new MTTSException(ErrorCode.NOT_FOUND, "Movies not found for Genre");
		}
		return mList;
	}

	@Override
	public Movie getMovieById(long id) {
		// TODO Auto-generated method stub
		Movie mfound = mRepository.findOne(id);
		if(mfound==null){
			throw new MTTSException(ErrorCode.NOT_FOUND, "Movie not found");
		}
		return mfound;
	}		
}


