package com.springrestapi.springrestapi.exception;
import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;



import net.bytebuddy.asm.Advice.Return;

@ControllerAdvice
public class ExceptionHandler {
	
	//-------------------------------------------------------------------------//
	//									SELLER EXCEPTIONS
	//-------------------------------------------------------------------------//
	@org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDetails> sellerHandler(UserNotFoundException error, WebRequest webRequest) {
		
		ErrorDetails errorDetail = new ErrorDetails(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Bad Request", error.getMessage());
		
		return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
	}
	
	
}