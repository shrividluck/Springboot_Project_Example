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
	public Iterable<Movie> getMovies(String name) {
		// TODO Auto-generated method stub
		List<Movie> list = new ArrayList<Movie>();
		list.add(new MovieImpl("The Mummy"));
		list.add(new MovieImpl("SpiderMan Homecoming"));
		return list;
	}
}
