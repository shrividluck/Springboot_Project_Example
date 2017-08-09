package com.shri.mtts.service;
import com.shri.mtts.entity.Showtimes;


public interface ShowtimesService {
	
	Iterable<Showtimes> getAllMovieShowtimes(String theater);
	
	Iterable<Showtimes> getAllTheaterShowtimes(String movie);
	
	void updateShowtime(String movie, String theater, String time);
}
