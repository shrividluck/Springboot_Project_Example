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
import org.springframework.stereotype.Service;

import com.shri.mtts.entity.Movie;
import com.shri.mtts.entity.impl.MovieImpl;
import com.shri.mtts.service.MovieService;


@Service
public class MovieServiceImpl implements MovieService {

	@Override
	public Movie addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movie;
	}

	@Override
	public void updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Movie getMovie(String string) {
		// TODO Auto-generated method stub
		return new MovieImpl(string);
		
		
	}

	@Override
	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		List<Movie> list = new ArrayList<Movie>();
		list.add(new MovieImpl("The Mummy"));
		list.add(new MovieImpl("SpiderMan Homecoming"));
		list.add(new MovieImpl("Despicable Me"));
		list.add(new MovieImpl("Kung Fu Panda"));
		return list;
	}

	@Override
	public Movie getMovie(long id) {
		// TODO Auto-generated method stub
		return new MovieImpl(id);
	}

	@Override
	public List<Movie> getMoviesByGenre(String gen) {
		// TODO Auto-generated method stub
		if(gen.equals("Action")) {
			List<Movie> list = new ArrayList<Movie>();
			list.add(new MovieImpl("The Mummy"));
			list.add(new MovieImpl("SpiderMan Homecoming"));
			return list;
		} else if(gen.equals("Comedy")) {
			List<Movie> list = new ArrayList<Movie>();
			list.add(new MovieImpl("Despicable Me"));
			list.add(new MovieImpl("Kung Fu Panda"));
			return list;
			
		}
		return null;
	}

	/*@Override
	public  getMovieRatings(String movieName) {
		// TODO Auto-generated method stub
		MovieImpl mI = new MovieImpl(movieName);
		return mI.getMovieRatings();
	}

	@Override
	public Movie getMovieReviews(String movieName) {
		// TODO Auto-generated method stub
		MovieImpl mI = new MovieImpl(movieName);
		return mI;
	}

	@Override
	public String getMovieSynopsis(String movieName) {
		// TODO Auto-generated method stub
		MovieImpl mI = new MovieImpl(movieName);
		return mI.getMovieSynopsis();
	}

	@Override
	public String getMovieCastAndCrew(String movieName) {
		// TODO Auto-generated method stub
		MovieImpl mI = new MovieImpl(movieName);
		return mI.getMovieCastCrew();
	}

	@Override
	public Movie getMovieInfo(String mv) {
		// TODO Auto-generated method stub
		StringBuilder res  = new StringBuilder();
		res.append(getMovieSynopsis(mv));
		//res.append(getMovieCastAndCrew(mv));
		return res.toString();
	}*/
}
