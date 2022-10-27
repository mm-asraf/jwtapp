package com.springrestapi.springrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException() {
	}
	
String message;
	
	
	
	public UserNotFoundException(String message) {
		super();
		this.message = message;
		
	
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	@Override
	public String toString() {
		return "UserNotFoundException [message=" + message + "]";
	}
	
	
	
}