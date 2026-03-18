package com.Aadi.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionApp {
     
	@ExceptionHandler (value = Exception.class)
	public String exceptionhandler(Exception e) {
		
		return e.getMessage();
		
	
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handlemethodargumentexception(MethodArgumentNotValidException e) {
		
		Map<String,String> errors = new HashMap<String,String>();
		
		e.getBindingResult().getFieldErrors().forEach(error->{
			
			errors.put(error.getField(), error.getDefaultMessage());
			
		});
		
		return new ResponseEntity<Map<String,String>>(errors, HttpStatus.BAD_REQUEST);
		
		
	}
	

	
	
	
}
