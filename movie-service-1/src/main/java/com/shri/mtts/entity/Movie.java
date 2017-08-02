package com.shri.mtts.entity;

import java.util.List;

public interface Movie {
	long getMovieId();	
	//void setMovieId();
	String getMovieName();
	//void setMovieName(Long id);
	String getMovieGenre(); 
	void setMovieGenre(String genre); 
	
	String getMovieCastCrew();
	String getMovieRatings();
	String getMovieReviews();	
	String getMovieSynopsis();
	//List<String> getTheatersPlayingMovie();  // ??? get list of theaters playing the movie.
	//String getTheatersPlayingAsString();
	boolean equals(Object obj);
}
