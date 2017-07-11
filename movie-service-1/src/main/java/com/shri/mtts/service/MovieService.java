package com.shri.mtts.service;

import java.util.List;

import com.shri.mtts.entity.Movie;

/*
 *
a. Browse all movies available in the system
b. Filter movies by name
c. Filter movies by genre
d. Get ratings by entering movie name
e. Get reviews by entering movie name
f. Get movie cast and crew info by entering movie name
g. Get movie synopsis by entering movie name
h. Get list of theaters my entering movie name.
 * 
 */


public interface MovieService {
	
	Movie addMovie(Movie movie);

	void updateMovie(Movie movie);

	Movie getMovie(String string);
	
	Movie getMovie(long id);
	
	List<Movie> getMovies();
	
	List<Movie> getMoviesByGenre(String gen);
	
	/*String getMovieRatings(String movieName);
	
	String getMovieReviews(String movieName);
	
	String getMovieSynopsis(String movieName);
	
	String getMovieCastAndCrew(String movieName);

	String getMovieInfo(String movieName); // returns all available info about a movie.*/

    
}