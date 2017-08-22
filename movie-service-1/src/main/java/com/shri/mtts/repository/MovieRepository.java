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
  
	Iterable<MovieImpl> findByGenreContaining(String genre);
    
	Iterable<MovieImpl> findByMovieNameContaining(String movieName); 
	
    MovieImpl findByMovieName(String movieName); 
	
}
