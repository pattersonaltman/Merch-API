package com.cognixia.jump.exception;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

// before the controller gives a response, gets some advice
// on how to construct that response here (exception)
@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFound(ResourceNotFoundException ex, WebRequest request) {
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		
		return ResponseEntity.status(404).body(errorDetails);
	}
	
	
	
	
	
	@ExceptionHandler(ResourceAlreadyExistsException.class)
	public ResponseEntity<?> resourceNotFound(ResourceAlreadyExistsException ex, WebRequest request) {
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		
		return ResponseEntity.status(404).body(errorDetails);
	}
	
	
	

	// maybe to use ...
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<?> methodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request) {
//		
//		StringBuilder errors = new StringBuilder("");
//		for(FieldError fe : ex.getBindingResult().getFieldErrors()) {
//			errors.append( "[" + fe.getField() + " : " + fe.getDefaultMessage() + "]; " );
//		}
//		
//		ErrorDetails errorDetails = new ErrorDetails(new Date(), errors.toString(), request.getDescription(false) );
//		
//		return ResponseEntity.status(400).body(errorDetails);
//		
//	}
//	
	

	
	
	
	
}
