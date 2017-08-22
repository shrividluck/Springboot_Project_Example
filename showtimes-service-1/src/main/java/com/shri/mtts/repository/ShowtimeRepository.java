/**
 * 
 */
/**
 * @author shrividluck
 *
 */
package com.shri.mtts.repository;
import org.springframework.data.repository.CrudRepository;
import com.shri.mtts.entity.impl.ShowtimesImpl;



public interface ShowtimeRepository extends CrudRepository<ShowtimesImpl, Long> {
	
	Iterable<ShowtimesImpl> findByTheaterContaining(String theater);
    
	Iterable<ShowtimesImpl> findByMovieContaining(String movie); 
	
	Iterable<ShowtimesImpl> findByMovieAndTheaterContaining(String movie, String theater); 
}
