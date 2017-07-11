package com.shri.mtts.entity;

public interface Showtimes {
	long getId();	
	String getTheaterShowtimes();  // For all movies playing in a particular theater
	String getAllTheaterShowtimes();     // Show times in all theaters
	String getDateBasedShowtimes();     // Show times based on Date entered
	
}