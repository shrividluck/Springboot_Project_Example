package com.shri.mtts.service;

import java.util.List;

import com.shri.mtts.entity.Movie;
import com.shri.mtts.entity.impl.MovieImpl;




public interface MovieService {
	
	Movie addMovie(Movie movie);

	Movie updateMovie(Movie movie);

	Movie getMovie(String string);
	
	Iterable<MovieImpl> getAllMovies();
	
	Iterable<MovieImpl> getMoviesByGenre(String gen);

	Movie getMovieById(long id);

}
