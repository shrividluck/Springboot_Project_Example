package com.shri.mtts.service;
import java.util.List;

import com.shri.mtts.entity.Theater;
import com.shri.mtts.entity.impl.TheaterImpl;


public interface TheaterService {
	
	/*
a. Browse all theaters available in the system.
b. Browse all movies playing in a particular theatre
c. Filter theaters by entering zip code.
d. Filter theaters by movie name and zip code.
e. Get address by entering theater name.
f. Get reviews and ratings of the theater by name
g. Get list of upcoming movies in that theater
	 */
	
	void addMovieToTheater(String movie, Theater Th);
	
	Theater addTheater(String theaterName);

	Theater addTheater(Theater theater);
	
	Iterable<TheaterImpl> getTheaterList(String movieName);

	Iterable<TheaterImpl> getTheaterList(int pinCode);
	
	Iterable<TheaterImpl> getTheaterList(String mName, int pinCode);

	Theater getTheaterName(long id);

	List<String> getMoviesInTheater(String theater);
	
	List<String> getUpComingMoviesInTheater(String theater);

	Theater getTheaterName(String tName);

	Iterable<TheaterImpl> getTheaterListByName(String tName);

}
