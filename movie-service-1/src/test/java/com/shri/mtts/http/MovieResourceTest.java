
/**
 * @author shrividya
 *
 */
package com.shri.mtts.http;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shri.mtts.entity.impl.MovieImpl;
import com.shri.mtts.http.entity.HttpMovie;
import com.shri.mtts.repository.MovieRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieResourceTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@MockBean
	private MovieRepository mRepository;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testGetMovies() throws Exception {
		doReturn(Arrays.asList(new MovieImpl())).when(mRepository).findAll();
		
		MvcResult mockResponse = mockMvc.perform(get("/movies").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andReturn();
		assertThat(mockResponse.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());

		String expectedResponseBody =  "[{\"id\":0}]";
		String mvcResponse = new String(mockResponse.getResponse().getContentAsByteArray());
		JSONAssert.assertEquals(expectedResponseBody, mvcResponse, true);
		
		verify(mRepository, times(1)).findAll();
		verifyNoMoreInteractions(mRepository);
	}
	
	@Test
	public void testGetMoviesByGenre() throws Exception {
		doReturn(Arrays.asList(new MovieImpl())).when(mRepository).findByGenreContaining("Action");
		
		MvcResult mockResponse = mockMvc.perform(get("/movies/GENRE/Action").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andReturn();
		assertThat(mockResponse.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());

		String expectedResponseBody = "[{\"id\":0}]";
		String mvcResponse = new String(mockResponse.getResponse().getContentAsByteArray());
		JSONAssert.assertEquals(expectedResponseBody, mvcResponse, true);
		
		verify(mRepository, times(1)).findByGenreContaining("Action");
		verifyNoMoreInteractions(mRepository);
		
	}


	@Test
	public void testGetMovieInfoByName() throws Exception {
        doReturn((new MovieImpl())).when(mRepository).findByMovieName("ABC");
		
		MvcResult mockResponse = mockMvc.perform(get("/movies/movie/ABC").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andReturn();
		assertThat(mockResponse.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());

		String expectedResponseBody = "{\"id\":0}";
		String mvcResponse = new String(mockResponse.getResponse().getContentAsByteArray());
		JSONAssert.assertEquals(expectedResponseBody, mvcResponse, true);
		
		verify(mRepository, times(1)).findByMovieName("ABC");
		verifyNoMoreInteractions(mRepository);
	}

	@Test
	public void testCreateMovie() throws Exception {
		MovieImpl mockMovie = new MovieImpl();
		mockMovie.setMovieName("ABC");
		mockMovie.setMovieGenre("Action");
		mockMovie.setMovieRatings("great");
		
		doReturn(mockMovie).when(mRepository).save(any(MovieImpl.class));
		
		MvcResult mockResponse = mockMvc.perform(post("/movies").accept(MediaType.APPLICATION_JSON).content(getNewMovie())
				.contentType(MediaType.APPLICATION_JSON)).andDo(print()).andReturn();
		assertThat(mockResponse.getResponse().getStatus()).isEqualTo(HttpStatus.CREATED.value());

		String expectedResponseBody = new String(Files.readAllBytes(Paths.get("src/test/resources/movies-create.json")));
		String mvcResponse = new String(mockResponse.getResponse().getContentAsByteArray());
		JSONAssert.assertEquals(expectedResponseBody, mvcResponse, true);
		
		verify(mRepository, times(1)).save(any(MovieImpl.class));
		//verifyNoMoreInteractions(tRepository);
	}

	private String getNewMovie() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

		HttpMovie mv = new HttpMovie();
		mv.Name = "ABC";
		mv.Genre = "Action";
		mv.Ratings = "great";
		return mapper.writeValueAsString(mv);
	}
	
	
	
}