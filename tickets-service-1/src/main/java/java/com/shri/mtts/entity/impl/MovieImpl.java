
/**
 * @author shrividluck
 */
package com.shri.mtts.entity.impl;
import com.shri.mtts.entity.Movie;

public class MovieImpl implements Movie {

		
	private String movieName;
	private String genre;
	private String castCrew;
	private String ratings;
	private String reviews;	
	private String synopsis;
	
	public MovieImpl() {
	}
	
	public MovieImpl(String string) {
		this.movieName = string;
	}
	
	public String getMovieName() {
		// TODO Auto-generated method stub
		return movieName;
	}
	
	public String getGenre() {
		// TODO Auto-generated method stub
		return genre;
	}
	
	public String getMovieCastCrew() {
		// TODO Auto-generated method stub
		return castCrew;
	}
	
	public String getMovieRatings() {
		// TODO Auto-generated method stub
		return ratings;
	}
	
	public String getReviews() {
		// TODO Auto-generated method stub
		return reviews;
	}
	
	public String getSynopsis() {
		// TODO Auto-generated method stub
		return synopsis;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCastCrew() {
		return castCrew;
	}
	public void setCastCrew(String castCrew) {
		this.castCrew = castCrew;
	}
	public String getRatings() {
		return ratings;
	}
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	public void setReviews(String reviews) {
		this.reviews = reviews;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}