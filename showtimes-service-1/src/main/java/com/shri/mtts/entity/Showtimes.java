package com.shri.mtts.entity;

public interface Showtimes {
	long getId();	
	String getAllTheaterShowtimes(String movie);// Show times in all theaters
	String getAllMovieShowtimes(String theater);
	String getMovieShowtimeForTheater(String movie, String theater);
	void setMovieShowtimeForTheater(String movie, String theater, String time);
}
