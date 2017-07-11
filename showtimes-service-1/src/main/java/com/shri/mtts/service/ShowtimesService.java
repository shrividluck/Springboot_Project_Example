package com.shri.mtts.service;
import com.shri.mtts.entity.Showtimes;

public interface ShowtimesService {
	Showtimes addMovie(Showtimes movie);

	void updateMovie(Showtimes movie);

	Showtimes getMovie(long Id);

	/**
	 * Search user by first or last name, partial searches also performed
	 * 
	 * @param firstName
	 * @param lastName
	 * @return Empty list is returned if none found
	 */
	Iterable<Showtimes> getMovies(String name);

	//boolean isATMPinValid(long userId, String pin);

}