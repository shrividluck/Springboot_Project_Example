
/**
 * @author shrividluck
 */
package com.shri.mtts.entity.impl;
import java.util.List;

import com.shri.mtts.entity.Movie;

public class MovieImpl implements Movie {

	private Long movieId;	
	private String movieName;
	private String genre;
	private String castCrew;
	private String ratings;
	private String reviews;	
	private String synopsis;
	private List<String> theatersPlayingMovie;
	
	public MovieImpl() {
	}
	
	public MovieImpl(String movieName) {
		this.movieName = movieName;
		this.setMovieId((long) 1234);
		this.genre = "default";
		this.castCrew = "generic";
		this.ratings = "*****";
		this.reviews = "defaultReview";
		this.synopsis = "defaultSynopsis";
	}
	
	public MovieImpl (long id, String mName, String gen, String cc, String rat, String rev, String syn) {
		this.setMovieId(id);
		this.movieName = mName;
		this.genre = gen;
		this.castCrew = cc;
		this.ratings = rat;
		this.reviews = rev;
		this.synopsis = syn;
	}
	
	public MovieImpl(long id2) {
		// TODO Auto-generated constructor stub
		this.setMovieId(id2);
	}
    
    // new
	@Override
	public List<String> getTheatersPlayingMovie() {
		// TODO Auto-generated method stub
		return this.theatersPlayingMovie;
	}
    // new
	public void setTheatersPlayingMovie(List<String> theatersPlaying) {
		for(String theater: theatersPlaying) {
			 this.theatersPlayingMovie.add(theater);
		}
	}
    // new
	@Override
	public long getMovieId() {
		// TODO Auto-generated method stub
		return 0;
	}
    // new
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	@Override
	public String getMovieCastCrew() {
		// TODO Auto-generated method stub
		return this.castCrew;
	}

	public void setMovieCastCrew(String cc) {
		 this.castCrew = cc;
	}
	
	@Override
	public String getMovieRatings() {
		// TODO Auto-generated method stub
		return this.ratings;
	}

	public void setMovieRatings(String rat) {
		// TODO Auto-generated method stub
		this.ratings = rat;
	}
	@Override
	public String getMovieReviews() {
		// TODO Auto-generated method stub
		return this.reviews;
	}

	public void setMovieReviews(String rev) {
		// TODO Auto-generated method stub
		this.reviews = rev;
	}
	@Override
	public String getMovieSynopsis() {
		// TODO Auto-generated method stub
		return this.synopsis;
	}

	public void setMovieSynopsis(String syn) {
		// TODO Auto-generated method stub
		this.synopsis = syn;
	}
	
	@Override
	public String getMovieName() {
		// TODO Auto-generated method stub
		return this.movieName;
	}
	
	public void setMovieName(String mName) {
		// TODO Auto-generated method stub
		this.movieName = mName;
	}
	
	@Override
	public String getMovieGenre() {
		// TODO Auto-generated method stub
		return this.genre;
	}
	
	public void setMovieGenre(String gen) {
		// TODO Auto-generated method stub
		this.genre = gen;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        if(((Movie)obj).getMovieName().equals(this.getMovieName())) {
        	return true;
        }
		return false;
	}

				
}