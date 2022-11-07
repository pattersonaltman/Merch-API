package com.cognixia.jump.exception;

import java.util.Optional;

public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
	
	
	
	
//	public ResourceNotFoundException(String resource, Long id) {
//		super(resource + " was not found with id = " + id);
//	}
	
	
	
	public ResourceNotFoundException(String resource, Long id) {
		super("[" + resource + "]" + " with id = [" + id + "] was not found");
	}
	
	
	
	public ResourceNotFoundException(String resource, String username) {
		super("[" + resource + "]" + " with username = [" + username + "] was not found");
	}
	
	
	public ResourceNotFoundException(String resource, String subject, String value) {
		super("[" + resource + "]" + " with " + subject + " = [" + value + "] was not found");
	}
	
	
	

}
