package com.shri.mtts.service.exception;

/**
 * Root of our exception heirarchy
 * @author shri
 *
 */
@SuppressWarnings("serial")
public class MTTSException extends RuntimeException {
	private ErrorCode errorCode;

	public MTTSException(ErrorCode code, String message, Throwable throwable) {
		super(message, throwable);
		this.errorCode = code;
	}
	
	public MTTSException(ErrorCode code, String message) {
		super(message);
		this.errorCode = code;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

}
