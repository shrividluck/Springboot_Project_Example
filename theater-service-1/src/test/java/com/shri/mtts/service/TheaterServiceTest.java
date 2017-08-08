/**
 * 
 */
/**
 * @author shrividluck
 *
 */
package com.shri.mtts.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import com.shri.mtts.entity.Theater;
import com.shri.mtts.entity.impl.TheaterImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TheaterServiceTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private TheaterService theaterService;

	/*
a. Browse all theaters available in the system.
b. Browse all movies playing in a particular theatre
c. Filter theaters by entering zip code.
d. Filter theaters by movie name and zip code.
e. Get list of upcoming movies in that theater
	 */



	@Test
	public void getTheaterList() {


		TheaterImpl tImpl = new TheaterImpl("theater_1");
		tImpl.setId(1);
		tImpl.setPlayingMovies(new ArrayList<String>(Arrays.asList("movie-1","movie-B","movie-C")));
		tImpl.setPincode(12345); 

		Theater t = theaterService.addTheater(tImpl);
		assertThat(theaterService.getTheaterList(12345), is(new ArrayList<>(Arrays.asList(t))));
		assertThat(theaterService.getTheaterList("movie-B"), is(new ArrayList<>(Arrays.asList(t))));
		assertThat(theaterService.getTheaterList("movie-1", 12345), is(new ArrayList<>(Arrays.asList(t))));
	}

	@Test
	public void getMoviesInTheater() throws Exception {

		TheaterImpl tImpl = new TheaterImpl("theater_2");
		tImpl.setId(5);
		tImpl.setPincode(12346);
		tImpl.setPlayingMovies(new ArrayList<String>(Arrays.asList("movie-1","movie-2","movie-3")));
		Theater t = theaterService.addTheater(tImpl);
		assertThat(theaterService.getMoviesInTheater("theater_2"), 
				is(new ArrayList<String>(Arrays.asList("movie-1","movie-2","movie-3"))));
	}


	@Test
	public void getUpMoviesInTheater() throws Exception {

		TheaterImpl tImpl = new TheaterImpl("theater_3");
		tImpl.setId(2);
		tImpl.setPincode(12347);
		tImpl.setPlayingMovies(new ArrayList<String>(Arrays.asList("movie-1","movie-2","movie-3")));
		tImpl.setUpComingMovies(new ArrayList<String>(Arrays.asList("movie-4","movie-5","movie-6")));
		Theater t = theaterService.addTheater(tImpl);
		assertThat(theaterService.getUpComingMoviesInTheater("theater_3"), 
				is(new ArrayList<String>(Arrays.asList("movie-4","movie-5","movie-6"))));


	}
}