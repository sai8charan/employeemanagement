package com.project.employeemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler{

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<ExceptionPayLoad> handleInvalidInputException(Exception e) {
		HttpStatus badrequest = HttpStatus.INTERNAL_SERVER_ERROR;
		ExceptionPayLoad payload = new ExceptionPayLoad(500, e.getMessage());

		return new ResponseEntity<>(payload, badrequest);
	}
	
	
}
