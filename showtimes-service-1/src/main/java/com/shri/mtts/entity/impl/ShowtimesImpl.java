
/**
 * @author shri
 */
package com.shri.mtts.entity.impl;
import com.shri.mtts.entity.Showtimes;



public class ShowtimesImpl implements Showtimes {

	private long id;	
	private String theaterShowtimes;
	private String allTheaterShowtimes;
	private String dateBasedShowtimes;
	
	
	public ShowtimesImpl() {
	}
	
	public ShowtimesImpl(long id) {
		this.id = id;
	}
	
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getTheaterShowtimes() {
		// TODO Auto-generated method stub
		return theaterShowtimes;
	}

	public void setTheaterShowtimes(String theaterShowtimes) {
		this.theaterShowtimes = theaterShowtimes;
	}

	public String getAllTheaterShowtimes() {
		return allTheaterShowtimes;
	}

	public void setAllTheaterShowtimes(String allTheaterShowtimes) {
		this.allTheaterShowtimes = allTheaterShowtimes;
	}

	public String getDateBasedShowtimes() {
		return dateBasedShowtimes;
	}

	public void setDateBasedShowtimes(String dateBasedShowtimes) {
		this.dateBasedShowtimes = dateBasedShowtimes;
	}
	
}