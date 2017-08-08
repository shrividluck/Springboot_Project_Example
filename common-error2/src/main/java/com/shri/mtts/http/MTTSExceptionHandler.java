package com.shri.mtts.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shri.mtts.http.entity.HttpError;
import com.shri.mtts.service.exception.MTTSException;

/**
 * Exception handling advice - for all controllers
 * @author shrividya
 *
 */
@ControllerAdvice
public class MTTSExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@ExceptionHandler({Exception.class})
	@ResponseBody
	public ResponseEntity<HttpError> handleIllegalArgumentException(MTTSException e){
		logger.info("MTTS Exception handler",e);		
		return new ResponseEntity<>(new HttpError(e), HttpStatus.CONFLICT); 
	}
}
