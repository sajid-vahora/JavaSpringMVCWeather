package com.pactera.aw.exception;


public class DataNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	

	public DataNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}



	public DataNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}



	public DataNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}



	public DataNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}



	public DataNotFoundException(String errorCode, Throwable cause) {
		super(errorCode, cause);
	}

}
