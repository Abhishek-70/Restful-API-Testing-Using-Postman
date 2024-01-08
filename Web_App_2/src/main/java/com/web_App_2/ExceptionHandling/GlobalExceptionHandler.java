package com.web_App_2.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//It acts LIke A Catch block for Handling any Exception Which Occur In Our Project using @ControllerAdvice
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
//(ResponseEntityExceptionHandler) class make It as a Special Class Which is able to Handle Any Exception In our project
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> ResourceNotFoundException(
			ResourceNotFoundException e,
			WebRequest webreq
			){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	//It will Handle All Type Of exception In the Project 
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> Exception(
			Exception e,
			WebRequest webreq
			){
		
		return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
