package com.shri.mtts.http.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.shri.mtts.service.exception.MTTSException;

@JsonInclude(value=Include.NON_NULL)
public class HttpError {
	public int status;	
	public String code;	
	public String message;
	public String debug;

	protected HttpError(){}
	
	public HttpError(MTTSException ex) {
		status=409;
		code=ex.getErrorCode()==null?"":ex.getErrorCode().name();
		message=ex.getMessage();
		debug=ex.getCause()==null?"":"caused by"+ex.getCause().getMessage();		
	}
}
