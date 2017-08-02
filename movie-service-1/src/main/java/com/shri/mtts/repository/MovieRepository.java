/**
 * 
 */
/**
 * @author shrividluck
 *
 */
package com.shri.mtts.repository;
import org.springframework.data.repository.CrudRepository;

import com.shri.mtts.entity.impl.MovieImpl;



public interface MovieRepository extends CrudRepository<MovieImpl, Long> {
	
	//Iterable<MovieImpl> findByPincodeContainingAndMoviesPlayingContaining(long pincode, String movieName); //???
   
	Iterable<MovieImpl> findByGenreContaining(String genre);
    
    // ??? to get list of theaters playing the movie based on movieName.
	//Iterable<MovieImpl> findByTheaterNameContaining(String theaterName); 

	// return castCrew , synopsis and ratings from DB.
	Iterable<MovieImpl> findByMovieNameContaining(String movieName); 
	
	// return ExactMovie.
     MovieImpl findByMovieName(String movieName); 
	
	// return movieImpl based on id param
	//Iterable<MovieImpl> finfBymovieId(Long id);
	
}
