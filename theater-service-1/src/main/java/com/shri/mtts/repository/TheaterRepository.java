/**
 * 
 */
/**
 * @author shrividluck
 *
 */
package com.shri.mtts.repository;
import org.springframework.data.repository.CrudRepository;

import com.shri.mtts.entity.impl.TheaterImpl;


public interface TheaterRepository extends CrudRepository<TheaterImpl, Long> {
	
	Iterable<TheaterImpl> findByPincodeAndMoviesPlayingContaining(int pincode, String movieName); //???

	Iterable<TheaterImpl> findByTheaterNameContaining(String theaterName);
	
	TheaterImpl findByTheaterName(String theaterName);

	Iterable<TheaterImpl> findByMoviesPlayingContaining(String movieName); // ???
	
	Iterable<TheaterImpl> findByPincode(int pincode);
}
