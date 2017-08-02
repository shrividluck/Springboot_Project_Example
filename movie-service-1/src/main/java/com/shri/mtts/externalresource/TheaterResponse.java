package com.shri.mtts.externalresource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TheaterResponse {
	public long id;	
	public Iterable<String> theater;

	public TheaterResponse(){		
	}

	@Override
	public String toString() {
		return " ";
	}
}
