
/**
 * @author shrividluck
 */
package com.shri.mtts.entity.impl;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.shri.mtts.entity.Theater;

@Entity
@Table(name = "theaters")
public class TheaterImpl implements Theater {
	@Id
	@Column(name = "idtheaters")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 

	@Column(name = "theater_name")
	private String theaterName;

	@Column(name = "theater_address")
	private String theaterAddress;

	@Column(name = "movies_playing")
	private String moviesPlaying;

	@Column(name = "upcoming_movies")
	private String upcomingMovies;

	@Column(name = "pincode")
	private int pincode;

	public TheaterImpl() {
	}

	
	public TheaterImpl(String tName) {
		this.theaterName = tName;
	}
	

	@Override
	public long getId() {
		return this.id;
	}
	
	@Override
	public void setId(int in) {
		this.id = in;
	}
	
	@Override
	public List<String> getMoviesPlaying() {
		return Arrays.asList(this.moviesPlaying.split(";"));
	}
	
	
	@Override
	public String getTheaterAddress() {
		return this.theaterAddress;
	}
	
	
	@Override
	public List<String> getUpcomingMovies() {
		return Arrays.asList(this.upcomingMovies.split(";"));
	}
	
	
	@Override
	public String getTheaterName() {
		return this.theaterName;
	}
	

	@Override
	public int getPincode() {
		return pincode;
	}

	
	public void setTheaterName(String TName) {
		this.theaterName = TName;

	}
	

	public void setUpComingMovies(List<String> UpMovies) {
		StringBuffer sB = new StringBuffer();
		Boolean flag = false;
		// populate the sB with pre existing movies
		if(this.upcomingMovies != null) {
			sB.append(this.upcomingMovies);
		} else {
			flag = true;
		}


		for(String movie: UpMovies) {
			if(flag) {
				sB.append(movie);
				flag = false;
			} else {
				sB.append(";").append(movie);
			}			
		}
		this.upcomingMovies = sB.toString();
	}
	

	public void setPlayingMovies(String Movie) {
		StringBuffer sB = new StringBuffer();
		// populate the sB with pre existing movies
		if(this.moviesPlaying != null) {
			sB.append(this.moviesPlaying);
			sB.append(";").append(Movie);
		} else {
			sB.append(Movie);

		}
		this.moviesPlaying = sB.toString();
	}

	public void setPlayingMovies(List<String> Movies) {
		Boolean flag = false;
		StringBuffer sB = new StringBuffer();
		if(this.moviesPlaying != null) {
			sB.append(this.moviesPlaying);
		} else {
			flag = true;
		}		
		for(String movie: Movies) {
			if(flag) {
				sB.append(movie);
				flag = false;
			} else {
				sB.append(";").append(movie);
			}			
		}
		this.moviesPlaying = sB.toString();		
	}
	

	public void setUpComingMovies(String UpMovie) {

		StringBuffer sB = new StringBuffer();

		if(this.upcomingMovies != null) {
			sB.append(this.upcomingMovies);
			sB.append(";").append(UpMovie);
		} else {
			sB.append(UpMovie);
		}	
		this.upcomingMovies = sB.toString();
	}
	

	public void setTheaterAddress(String Address) {	
		this.theaterAddress = Address;		
	}
	
    @Override
	public void setPincode(int pincode) {
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
		
	
	public String toString() {
		return "theaterImpl [id : "  + id + ", theaterName : " + theaterName + ", pincode :" + pincode + ", playing_movies" + moviesPlaying+ "]";
	}


	@Override
	public String getMoviesPlayingAsString() {
		return this.moviesPlaying;
	}


	@Override
	public void setMoviesPlayingAsString(String movies) {
		this.moviesPlaying = movies;
		
	}
	
}