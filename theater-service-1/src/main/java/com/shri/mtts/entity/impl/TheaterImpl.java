
/**
 * @author shrividluck
 */
package com.shri.mtts.entity.impl;
import java.util.List;

import com.shri.mtts.entity.Theater;



public class TheaterImpl implements Theater {

	private long id;
	private String theaterName;
	private String theaterAddress;
	private List<String> moviesPlaying;
	private List<String> upcomingMovies;
	private long pincode;
	
	public TheaterImpl() {
	}
	
	public TheaterImpl(String tName) {
		this.theaterName = tName;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	@Override
	public List<String> getMoviesPlaying() {
		// TODO Auto-generated method stub
		return this.moviesPlaying;
	}
	@Override
	public String getTheaterAddress() {
		// TODO Auto-generated method stub
		return this.theaterAddress;
	}
	@Override
	public List<String> getUpcomingMovies() {
		// TODO Auto-generated method stub
		return this.upcomingMovies;
	}
	@Override
	public String getTheaterName() {
		// TODO Auto-generated method stub
		return this.theaterName;
	}
	
	@Override
	public long getPincode() {
		return pincode;
	}

	public void setTheaterName(String TName) {
		// TODO Auto-generated method stub
		this.theaterName = TName;
		
	}
	
	public void setUpComingMovies(List<String> UpMovies) {
		// TODO Auto-generated method stub
		for(String movie: UpMovies) {
			this.upcomingMovies.add(movie);	
		}
	}
	
	public void setPlayingMovies(String Movie) {
		// TODO Auto-generated method stub
		this.moviesPlaying.add(Movie);
		
	}
	
	public void setPlayingMovies(List<String> Movies) {
		// TODO Auto-generated method stub
		for(String movie:Movies) {
		 this.moviesPlaying.add(movie);
		}
		
	}
	
	public void setUpComingMovies(String UpMovie) {
		// TODO Auto-generated method stub
		this.upcomingMovies.add(UpMovie);
		
	}
	public void setTheaterAddress(String Address) {
		// TODO Auto-generated method stub
		this.theaterAddress = Address;
		
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        if(((Theater)obj).getTheaterName().equals(this.getTheaterName())) {
        	return true;
        }
		return false;
	}

	
}