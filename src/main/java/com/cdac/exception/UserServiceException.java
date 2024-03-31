package com.cdac.exception;

public class UserServiceException extends RuntimeException{

	public UserServiceException () {}
	
	public UserServiceException(String msg) {
		super(msg);
	}
	
	
}
