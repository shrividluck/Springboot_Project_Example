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

import com.shri.mtts.entity.Movie;
import com.shri.mtts.entity.impl.MovieImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieServiceTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private MovieService movieService;

	/*Movie addMovie(Movie movie);

	void updateMovie(Movie movie);

	Movie getMovie(String string);

	Movie getMovie(long id);

	Iterable<Movie> getMovies(String name);

	Iterable<Movie> getMoviesByGenre(String gen);*/


	@Test
	public void getMovie() {
		/*Movie mvGet = movieService.getMovie("Eye of the Tiger");

		assertThat(mvGet instanceof Movie).isTrue();
		assertThat(mvGet.getMovieName().equals("Eye of the Tiger"));

		System.out.println(mvGet);*/

		MovieImpl mImpl = new MovieImpl();
		mImpl.setMovieId((long) 1234);
		mImpl.setMovieName("Superman");
		mImpl.setMovieGenre("Superhero");
		mImpl.setMovieRatings("good");

		Movie t = movieService.addMovie(mImpl);
		assertThat(movieService.getMovie("SuperMan"), is(t));

	}

	@Test
	public void getMovies() {

		/*List<Movie> expected = new ArrayList<Movie>();
		expected.add(new MovieImpl("The Mummy"));
		expected.add(new MovieImpl("SpiderMan Homecoming"));
		expected.add(new MovieImpl("Despicable Me"));
		expected.add(new MovieImpl("Kung Fu Panda"));

		assertThat(expected, is(movieService.getAllMovies()));	// changed getMovies() to getAllMovies()	
		 */	
		
		MovieImpl mImpl = new MovieImpl();
	//	mImpl.setMovieId((long) 1234);
		mImpl.setMovieName("Superman");
		mImpl.setMovieGenre("Superhero");
		mImpl.setMovieRatings("good");
		
		Movie t = movieService.addMovie(mImpl);
		
		MovieImpl mImpl1 = new MovieImpl();
//		mImpl1.setMovieId((long) 5432);
		mImpl1.setMovieName("Home Alone");
		mImpl1.setMovieGenre("Comedy");
		mImpl1.setMovieRatings("good");
		
		Movie t1 = movieService.addMovie(mImpl1);
		
		assertThat(movieService.getAllMovies(), is(new ArrayList<>(Arrays.asList(t, t1))));
		assertThat(movieService.getMovie("SuperMan"), is(t));
		assertThat(movieService.getMovie("Home Alone"), is(t1));
	}

	@Test
	public void getMoviesGenre() throws Exception {

		/*	List<Movie> expectedA = new ArrayList<Movie>();
		List<Movie> expectedC = new ArrayList<Movie>();

		expectedA.add(new MovieImpl("The Mummy"));
		expectedA.add(new MovieImpl("SpiderMan Homecoming"));

		expectedC.add(new MovieImpl("Despicable Me"));
		expectedC.add(new MovieImpl("Kung Fu Panda"));



		assertThat(expectedA, is(movieService.getMoviesByGenre("Action")));
		assertThat(expectedC, is(movieService.getMoviesByGenre("Comedy")));
		assertThat(movieService.getMoviesByGenre("Horror")).isNull();*/
		
		MovieImpl mImpl = new MovieImpl();
		mImpl.setMovieId((long) 1234);
		mImpl.setMovieName("Superman");
		mImpl.setMovieGenre("Superhero");
		mImpl.setMovieRatings("good");
		
		Movie t = movieService.addMovie(mImpl);
		
		MovieImpl mImpl1 = new MovieImpl();
		mImpl1.setMovieId((long) 5432);
		mImpl1.setMovieName("Home Alone");
		mImpl1.setMovieGenre("Comedy");
		mImpl1.setMovieRatings("good");
		
		Movie t1 = movieService.addMovie(mImpl1);
		assertThat(movieService.getMoviesByGenre("Superhero"), is(new ArrayList<>(Arrays.asList(t))));
		assertThat(movieService.getMoviesByGenre("Comedy"), is(new ArrayList<>(Arrays.asList(t1))));

	}
}