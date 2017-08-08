/**
 * 
 */
/**
 * @author shrividya
 *
 */
package com.shri.mtts.http.entity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.shri.mtts.entity.Movie;



@JsonInclude(value=Include.NON_NULL)
public class HttpMovie {
	
	public long id;
	
	public String Name;
	
	public String Genre;
	
	public String Ratings;
	
	public HttpMovie() {
		
	}

	public HttpMovie(Movie mv ) {
		//this.id= mv.getMovieId();
		this.Name = mv.getMovieName();
		this.Genre = mv.getMovieGenre(); 
		this.Ratings = mv.getMovieRatings();
	}
	
}