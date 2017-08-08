package com.shri.mtts.entity;

import java.util.List;

public interface Theater {
	long getId();
	int getPincode();
	void setPincode(int pC);
	List<String> getMoviesPlaying();
	String getTheaterAddress();
	List<String> getUpcomingMovies();
	String getTheaterName();
	void setTheaterName(String tName);
	boolean equals(Object obj);
	String getMoviesPlayingAsString();
	void setMoviesPlayingAsString(String movies);
	void setId(int in);
}
