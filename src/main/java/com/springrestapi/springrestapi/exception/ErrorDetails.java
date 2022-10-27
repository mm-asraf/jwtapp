package com.springrestapi.springrestapi.exception;

import java.time.LocalDateTime;



public class ErrorDetails {
	
	private LocalDateTime timeStamp;
	
	private Integer status;
	
	private String error;
	
	private String message;

	public ErrorDetails() {
		super();
	}

	public ErrorDetails(LocalDateTime timeStamp, Integer status, String error, String message) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.error = error;
		this.message = message;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
