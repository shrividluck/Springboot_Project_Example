package com.shri.mtts.entity;

import java.util.List;

public interface Theater {
	long getId();
	long getPincode();
	List<String> getMoviesPlaying();
	//String getListOfTheaters();
	String getTheaterAddress();
	List<String> getUpcomingMovies();
	String getTheaterName();
	void setTheaterName(String tName);
	boolean equals(Object obj);
}
