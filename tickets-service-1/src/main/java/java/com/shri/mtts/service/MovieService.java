package com.shri.mtts.service;

import com.shri.mtts.entity.Movie;

public interface MovieService {
	
	Movie addMovie(Movie movie);

	void updateMovie(Movie movie);

	Movie getMovie(String string);

	
	Iterable<Movie> getMovies(String name);

	//boolean isATMPinValid(long userId, String pin);

}
