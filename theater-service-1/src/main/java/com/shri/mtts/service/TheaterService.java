package com.shri.mtts.service;
import java.util.List;

import com.shri.mtts.entity.Theater;


public interface TheaterService {
	
	/*
	 * 
	 * Browse all theaters available in the system.
b. Browse all movies playing in a particular theatre
c. Filter theaters by entering zip code.
d. Filter theaters by movie name and zip code.
e. Get address by entering theater name.
f. Get reviews and ratings of the theater by name
g. Get list of upcoming movies in that theater
	 */
	
	void addMovieToTheater(String movie, Theater Th);

	//void updateMovieInfo(String movieInfo);
	
	Theater addTheater(String theaterName);

	Theater addTheater(Theater theater);
	
/*	Theater getTheaterName(long id);
	
	Theater getTheaterName(String tName); // ?? */
	
	List<String> getMoviesInTheater(Theater theater);
	
	List<String> getUpComingMoviesInTheater(Theater theater);
	
	List<Theater> getTheaterList(String movieName);

	List<Theater> getTheaterList(long pinCode);
	
	List<Theater> getTheaterList(String mName, long pinCode);
		
}