package com.springrestapi.springrestapi.exception;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class GlobalExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
	public String exceptionHandler(UserNotFoundException unfe) {
		return "UserNotFoundExceptin:" + unfe.getMessage();
	}
}
