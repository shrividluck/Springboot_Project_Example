package com.shri.mtts.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Test class is independent 
 *  
 * @author shrividya
 *
 */
@JsonInclude(value=Include.NON_NULL)
public class HttpTheater {	
	public long id;
    public String Name;
	public int pincode;
	public String MoviesPlaying;

}
