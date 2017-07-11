package com.shri.mtts.entity;

import java.util.List;

public interface Movie {
	long getMovieId();	
	String getMovieName();
	String getMovieGenre(); 
	String getMovieCastCrew();
	String getMovieRatings();
	String getMovieReviews();	
	String getMovieSynopsis();
	List<String> getTheatersPlayingMovie();  // get list of theaters playing the movie.
	boolean equals(Object obj);
}
