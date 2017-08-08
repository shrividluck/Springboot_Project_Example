package com.shri.mtts.http;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import com.shri.mtts.http.HttpTheater;

import io.restassured.response.Response;

/**
 * Tests using Rest Assured
 * 
 * @author shrividya
 *
 */
public class TestTheaterResource {
	private static final String HTTP_HOST = "http://localhost:9080";

	@Test
	public void testGetUsersNoParams() {
		given().log().all()
		.when().get(HTTP_HOST + "/theaters")
		.then().log().all().statusCode(409).body("status", equalTo(409))
				.body("code", equalTo("MISSING_DATA")).body("message", equalTo("theater name required"));

	}

	@Test
	public void testCreateAndGetUser() {
		HttpTheater theater = new HttpTheater();
		theater.Name = "AMC-M";
		theater.pincode = 95054;
		theater.MoviesPlaying = "ABC;DEF";
		

		// execute post and retrieve response
		HttpTheater createdTheater = 
				given().log().all().contentType("application/json").body(theater)
				.when().post(HTTP_HOST + "/theaters")
				.as(HttpTheater.class);

		assertThat(createdTheater.Name).isEqualTo("AMC-M");
		assertThat(createdTheater.pincode == 95054);
		assertThat(createdTheater.MoviesPlaying).isEqualTo("ABC;DEF");
		assertThat(createdTheater.id).isNotNull();

		given().log().all().pathParam("movieN","ABC" )
		.when().get(HTTP_HOST + "/theaters/movie/{movieN}")
		.then().log().all().statusCode(200)
				.contentType("application/json")
				.body("Name",hasItems("AMC-M"));

	}
}
