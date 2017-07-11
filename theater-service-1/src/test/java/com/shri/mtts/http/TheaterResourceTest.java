
/**
 * @author shrividluck
 *
 */
package com.shri.mtts.http;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
import com.shri.mtts.http.entity.HttpTheater;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TheaterResourceTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testGetTheaterByPinCode() throws Exception {
		MvcResult mockResponse = mockMvc.perform(get("/theaters/zip/1234").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andReturn();
		assertThat(mockResponse.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());

		String expectedResponseBody = new String(Files.readAllBytes(Paths.get("src/test/resources/theater-list-pin.json")));
		String mvcResponse = new String(mockResponse.getResponse().getContentAsByteArray());
		JSONAssert.assertEquals(expectedResponseBody, mvcResponse, true);
		mockResponse = mockMvc.perform(get("/theaters/zip/123").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andReturn();
		assertThat(mockResponse.getResponse().getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
	
	@Test
	public void testGetTheaterByMoviePin() throws Exception {
		MvcResult mockResponse = mockMvc.perform(get("theaters/Mzip/1234/t1").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andReturn();
		assertThat(mockResponse.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());

		String expectedResponseBody = new String(Files.readAllBytes(Paths.get("src/test/resources/theater-list-movie-pin.json")));
		String mvcResponse = new String(mockResponse.getResponse().getContentAsByteArray());
		JSONAssert.assertEquals(expectedResponseBody, mvcResponse, true);
		
		mockResponse = mockMvc.perform(get("theaters/Mzip/1234/t2").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andReturn();
		assertThat(mockResponse.getResponse().getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		mockResponse = mockMvc.perform(get("theaters/Mzip/123/t1").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andReturn();
		assertThat(mockResponse.getResponse().getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
	}


	@Test
	public void testGetTheaterListByMovie() throws Exception {
		MvcResult mockResponse = mockMvc.perform(get("/theaters/movie/t1").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andReturn();
		assertThat(mockResponse.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
		

		String expectedResponseBody = new String(Files.readAllBytes(Paths.get("src/test/resources/theater-list-movie.json")));
		String mvcResponse = new String(mockResponse.getResponse().getContentAsByteArray());
		JSONAssert.assertEquals(expectedResponseBody, mvcResponse, true);
		
		 mockResponse = mockMvc.perform(get("/theaters/movie/t2").accept(MediaType.APPLICATION_JSON)).andDo(print())
					.andReturn();
			assertThat(mockResponse.getResponse().getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
}