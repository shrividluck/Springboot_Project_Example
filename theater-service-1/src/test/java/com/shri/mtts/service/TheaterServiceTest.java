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
e. Get address by entering theater name.
f. Get reviews and ratings of the theater by name
g. Get list of upcoming movies in that theater
*/
	
	
	
	@Test
	public void getTheaterList() {
		
		List<Theater> expectedPin = new ArrayList<Theater>();
		expectedPin.add(new TheaterImpl("theater-10"));
		expectedPin.add(new TheaterImpl("theater-11"));
		expectedPin.add(new TheaterImpl("theater-12"));
		expectedPin.add(new TheaterImpl("theater-13"));

		List<Theater> expectedMPin = new ArrayList<Theater>();
		expectedMPin.add(new TheaterImpl("theater-10"));
		expectedMPin.add(new TheaterImpl("theater-12"));
		
		assertThat(expectedPin, is(theaterService.getTheaterList(1234)));
		assertThat(expectedMPin, is(theaterService.getTheaterList("t1")));
		assertThat(expectedMPin, is(theaterService.getTheaterList("t1",1234)));
		assertThat(theaterService.getTheaterList(123)).isNull();
		assertThat(theaterService.getTheaterList("HMC")).isNull();
		assertThat(theaterService.getTheaterList("HMC", 234)).isNull();
	}
	
	@Test
	public void getMoviesInTheater() throws Exception {
		
		List<String> expectedA = new ArrayList<String>();
		List<String> expectedC = new ArrayList<String>();
		
		expectedA.add("T1");
		expectedA.add("T2");
		expectedA.add("SpiderMan HomeComing");
		
	    expectedC.add("NoMovie");
		
		
	    Theater t1 = new TheaterImpl("theater-10");
	    Theater t2 = new TheaterImpl("theater-11");
		
		assertThat(expectedA, is(theaterService.getMoviesInTheater(t1)));
		assertThat(expectedC, is(theaterService.getMoviesInTheater(t2)));
		
		
	}
	
	
	@Test
	public void getUpMoviesInTheater() throws Exception {
		List<String> expectedA = new ArrayList<String>();
		List<String> expectedC = new ArrayList<String>();
		
		expectedA.add("IronMan");
		expectedA.add("KingKong");
		expectedA.add("Dracula");
		
	    expectedC.add("NoMovie");
		
	    Theater t1 = new TheaterImpl("theater-10");
	    Theater t2 = new TheaterImpl("theater-11");
		
		assertThat(expectedA, is(theaterService.getUpComingMoviesInTheater(t1)));
		assertThat(expectedC, is(theaterService.getUpComingMoviesInTheater(t2)));
		
	}
}