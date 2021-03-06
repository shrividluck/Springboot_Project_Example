/**
 * 
 */
/**
 * @author shrividluck
 *
 */
package com.shri.mtts.http;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shri.mtts.entity.Theater;
import com.shri.mtts.entity.impl.TheaterImpl;
import com.shri.mtts.http.entity.HttpTheater;
import com.shri.mtts.service.TheaterService;


@RestController
@RequestMapping(value = "/theaters", produces = MediaType.APPLICATION_JSON_VALUE)
public class TheaterResource {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private TheaterService theaterService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpTheater> createTheater(@RequestBody HttpTheater newTheater) {		
		Theater TheaterToCreate = convert(newTheater);
		logger.info("Create Theater:" + TheaterToCreate);
		Theater addedTheater = theaterService.addTheater(TheaterToCreate);
		return new ResponseEntity<>(new HttpTheater(addedTheater), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<HttpTheater>> getTheaterAll(@RequestParam(value = "tName", required=false) String tName) {
		logger.info("Getting theater with Name "+ tName); 
		Iterable<TheaterImpl> found = theaterService.getTheaterListByName(tName);
		List<HttpTheater> returnList = new ArrayList<>();
		for (Theater theater: found) {
			returnList.add(new HttpTheater(theater));
		}
		return new ResponseEntity<>(returnList, HttpStatus.OK);
	}

	@RequestMapping(value = "/zip/{pinCode}", method = RequestMethod.GET)
	public ResponseEntity<List<HttpTheater>> getTheaterByPinCode(@PathVariable("pinCode") int pinCode) {
		logger.info("getting List of Theater by pincode :" + pinCode);
		Iterable<TheaterImpl> found = theaterService.getTheaterList(pinCode);
		if (found == null) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		List<HttpTheater> returnList = new ArrayList<HttpTheater>();
		for (Theater Theater : found) {
			returnList.add(new HttpTheater(Theater));
		}
		return new ResponseEntity<>(returnList, HttpStatus.OK);
	}

	@RequestMapping(value = "/movie/{tName}", method = RequestMethod.GET)
	public ResponseEntity<List<HttpTheater>> getTheaterSearch(@PathVariable("tName") String tName) {
		logger.info("Theater search based Name=" + tName );
		Iterable<TheaterImpl> found = theaterService.getTheaterList(tName);
		if (found == null) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		List<HttpTheater> returnList = new ArrayList<HttpTheater>();
		for (Theater Theater : found) {
			returnList.add(new HttpTheater(Theater));
		}
		return new ResponseEntity<>(returnList, HttpStatus.OK);
	}

	@RequestMapping(value = "/Mzip/{pinCode}/{movieName}", method = RequestMethod.GET)
	public ResponseEntity<List<HttpTheater>> getTheaterByPinCodeAndMovie(@PathVariable("pinCode") int pinCode,
			                                                             @PathVariable("movieName") String movieName ) {
		logger.info("getting List of Theater by pincode :" + pinCode + " and movieName : " + movieName);
		Iterable<TheaterImpl> found = theaterService.getTheaterList(movieName, pinCode);
		if (found == null) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		List<HttpTheater> returnList = new ArrayList<HttpTheater>();	
		for (Theater Theater : found) {
			returnList.add(new HttpTheater(Theater));
		}
		return new ResponseEntity<>(returnList, HttpStatus.OK);
	}
	
	private Theater convert(HttpTheater httpTheater) {
		Theater theater = new TheaterImpl();
		theater.setTheaterName(httpTheater.Name);
		theater.setPincode(httpTheater.pincode);
		theater.setMoviesPlayingAsString(httpTheater.MoviesPlaying);
		return theater;
	}
}
