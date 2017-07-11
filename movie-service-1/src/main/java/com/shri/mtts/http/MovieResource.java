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

import com.shri.mtts.entity.Movie;
import com.shri.mtts.entity.impl.MovieImpl;
import com.shri.mtts.http.entity.HttpMovie;
import com.shri.mtts.service.MovieService;

@RestController
@RequestMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieResource {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MovieService mS;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpMovie> createMovie(@RequestBody HttpMovie newMovie) {		
		Movie MovieToCreate = convert(newMovie);
		logger.info("Create Movie:" + MovieToCreate);
		Movie addedMovie = mS.addMovie(MovieToCreate);
		return new ResponseEntity<>(new HttpMovie(addedMovie), HttpStatus.CREATED);
	}

	/*@RequestMapping(value = "/{movieName}", method = RequestMethod.GET)
	public ResponseEntity<HttpMovie> getMovieById(@PathVariable("movieName") String movieName) {
		logger.info("getting MovieInfo by name:" + movieName);
		Movie movie = MovieService.getMovie(movieName);
		return new ResponseEntity<>(new HttpMovie(movie), HttpStatus.OK);
	}*/

	@RequestMapping(value = "/GENRE/{genre}", method = RequestMethod.GET)
	public ResponseEntity<List<HttpMovie>> getMovieByGenre(@PathVariable("genre") String genre) {
		logger.info("getting Movies by genre:" + genre);
		Iterable<Movie> movie = mS.getMoviesByGenre(genre);
		if(movie == null) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		List<HttpMovie> returnList = new ArrayList<HttpMovie>();
		for (Movie Movie : movie) {
			returnList.add(new HttpMovie(Movie));
		}
		return new ResponseEntity<>(returnList, HttpStatus.OK);
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<HttpMovie>> getMovieList() {
		logger.info("Movie list : All movies");
		Iterable<Movie> found = mS.getMovies();
		List<HttpMovie> returnList = new ArrayList<HttpMovie>();
		for (Movie Movie : found) {
			returnList.add(new HttpMovie(Movie));
		}
		return new ResponseEntity<>(returnList, HttpStatus.OK);
	}
     
	@RequestMapping(value = "/movie/{movieName}", method = RequestMethod.GET)
	public ResponseEntity<HttpMovie> getMovieInfo(@PathVariable("movieName") String movieName) {
		logger.info("getting Movies Info:" + movieName);
		Movie movie = mS.getMovie(movieName);	
	    return new ResponseEntity<>(new HttpMovie(movie), HttpStatus.OK);
		
	}
	
	/**
	 * 
	 * 
	 * @param newMovie
	 * @return
	 */
	private Movie convert(HttpMovie httpMovie) {
		MovieImpl movie = new MovieImpl();
		movie.setMovieName(httpMovie.Name);
		
		return movie;
	}
}