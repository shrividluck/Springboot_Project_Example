package com.shri.mtts.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * Test class is independent
 * @author shrividluck
 *
 */
@JsonInclude(value=Include.NON_NULL)
public class HttpError {
	public int status;	
	public String code;	
	public String message;
	public String debug;
}
