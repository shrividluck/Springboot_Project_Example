package com.shri.mtts.entity;

import java.util.List;

public interface Movie {
	long getMovieId();	
	String getMovieName();	
	String getMovieGenre(); 
	void setMovieGenre(String genre); 	
	String getMovieCastCrew();
	String getMovieRatings();
	String getMovieReviews();	
	String getMovieSynopsis();
	boolean equals(Object obj);
	void setMovieInTheater(boolean isMovieInTheater);
	boolean isMovieInTheater();
}
