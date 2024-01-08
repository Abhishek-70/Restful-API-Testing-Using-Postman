package com.web_App_2.ExceptionHandling;


public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(String message) {
		
		super(message);
		
	}
}
