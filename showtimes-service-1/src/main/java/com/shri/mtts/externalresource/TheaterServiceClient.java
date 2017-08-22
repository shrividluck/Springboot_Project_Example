package com.shri.mtts.externalresource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Connect with Theater Service using Rest Template
 * @author shrividya
 *
 */
@Component
public class TheaterServiceClient {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private RestTemplate theaterServiceRestTemplate;
	
	@Value("${theaterService.url}")
	private String theaterServiceUrl;

	public boolean theaterIsRunningMovie(String mName) {
		
		ResponseEntity<TheaterResponse[]> response = theaterServiceRestTemplate.exchange(theaterServiceUrl+"/theaters/movie/{movieName}", 
				HttpMethod.GET, null, TheaterResponse[].class, mName);
		
		logger.info("Theater response:"+response.getBody());
		
		if(response.getStatusCode()!=HttpStatus.OK){
			//some failure
			return false;
		}
		return true;
	}
}
