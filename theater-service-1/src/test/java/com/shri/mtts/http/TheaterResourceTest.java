
/**
 * @author shrividluck
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
import java.util.ArrayList;
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
import com.shri.mtts.entity.impl.TheaterImpl;
import com.shri.mtts.http.entity.HttpTheater;
import com.shri.mtts.repository.TheaterRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TheaterResourceTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private TheaterRepository tRepository;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

  @Test
   public void testGetTheaterNoParams() throws Exception {
	   MvcResult mockResponse = mockMvc.perform(get("/theaters/").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andReturn();
		assertThat(mockResponse.getResponse().getStatus()).isEqualTo(HttpStatus.CONFLICT.value());
		String expectedResponseBody = new String(Files.readAllBytes(Paths.get("src/test/resources/theater-error-missing-data.json")));
		String mvcResponse = new String(mockResponse.getResponse().getContentAsByteArray());
		JSONAssert.assertEquals(expectedResponseBody, mvcResponse, true);
   }

	@Test
	public void testGetTheaterByPinCode() throws Exception {
		doReturn(Arrays.asList(new TheaterImpl())).when(tRepository).findByPincode(95054);
		
		MvcResult mockResponse = mockMvc.perform(get("/theaters/zip/95054").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andReturn();
		assertThat(mockResponse.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());

		String expectedResponseBody = "[{\"id\":0,\"pincode\":0}]";
		String mvcResponse = new String(mockResponse.getResponse().getContentAsByteArray());
		JSONAssert.assertEquals(expectedResponseBody, mvcResponse, true);

		verify(tRepository, times(1)).findByPincode(95054);
		verifyNoMoreInteractions(tRepository);
	}

	@Test
	public void testGetTheaterByMoviePin() throws Exception {
		
        doReturn(Arrays.asList(new TheaterImpl())).when(tRepository).findByPincodeAndMoviesPlayingContaining(95054, "ABC");
		
		MvcResult mockResponse = mockMvc.perform(get("/theaters/Mzip/95054/ABC").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andReturn();
		assertThat(mockResponse.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());

		String expectedResponseBody = "[{\"id\":0,\"pincode\":0}]";
		String mvcResponse = new String(mockResponse.getResponse().getContentAsByteArray());
		JSONAssert.assertEquals(expectedResponseBody, mvcResponse, true);
		
		verify(tRepository, times(1)).findByPincodeAndMoviesPlayingContaining(95054, "ABC");
		verifyNoMoreInteractions(tRepository);
	}


	@Test
	public void testGetTheaterListByMovie() throws Exception {
        doReturn(Arrays.asList(new TheaterImpl())).when(tRepository).findByMoviesPlayingContaining("ABC");
		
		MvcResult mockResponse = mockMvc.perform(get("/theaters/movie/ABC").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andReturn();
		assertThat(mockResponse.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());

		String expectedResponseBody = "[{\"id\":0,\"pincode\":0}]";
		String mvcResponse = new String(mockResponse.getResponse().getContentAsByteArray());
		JSONAssert.assertEquals(expectedResponseBody, mvcResponse, true);
	
	}
	
	@Test
	public void testCreateTheater() throws Exception {
		TheaterImpl mockT = new TheaterImpl();
		mockT.setTheaterName("AMC-M");
		mockT.setPincode(95054);
		mockT.setPlayingMovies(new ArrayList<String>(Arrays.asList("ABC","DEF")));

		doReturn(mockT).when(tRepository).save(any(TheaterImpl.class));

		MvcResult mockResponse = mockMvc.perform(post("/theaters").accept(MediaType.APPLICATION_JSON).content(getNewTheater())
				.contentType(MediaType.APPLICATION_JSON)).andDo(print()).andReturn();
		assertThat(mockResponse.getResponse().getStatus()).isEqualTo(HttpStatus.CREATED.value());

		String expectedResponseBody = new String(Files.readAllBytes(Paths.get("src/test/resources/theaters-create.json")));
		String mvcResponse = new String(mockResponse.getResponse().getContentAsByteArray());
		JSONAssert.assertEquals(expectedResponseBody, mvcResponse, true);

		verify(tRepository, times(1)).save(any(TheaterImpl.class));
		//verifyNoMoreInteractions(tRepository);


	}

	private String getNewTheater() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

		HttpTheater theater = new HttpTheater();
		theater.Name = "AMC-M";
		theater.MoviesPlaying = "ABC;DEF";
		theater.pincode = 95054;
		return mapper.writeValueAsString(theater);
	}

}
