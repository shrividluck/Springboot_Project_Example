
/**
 * @author shri
 */
package com.shri.mtts.entity.impl;
import com.shri.mtts.entity.Showtimes;



public class ShowtimesImpl implements Showtimes {

	private long id;	
	String mvName;
	String tName;
	String time;
	private String allMovieShowtimes;
	private String allTheaterShowtimes;
	
	
	public ShowtimesImpl() {
	}
	
	public ShowtimesImpl(long id) {
		this.id = id;
	}
	
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getMovieShowtimeForTheater(String movie, String theater) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setMovieShowtimeForTheater(String movie, String theater, String time) {
		this.mvName = movie;
		this.tName = theater;
		this.time = time;
	}

	public String getAllTheaterShowtimes(String movie) {
		// TODO Auto-generated method stub
		return this.allTheaterShowtimes;
	}

	public String getAllMovieShowtimes(String theater) {
		// TODO Auto-generated method stub
		return this.allMovieShowtimes;
	}

	
}