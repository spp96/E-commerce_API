package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<ErrorDetails> loginExceptionhandler(LoginException login,WebRequest req){
		
		ErrorDetails error = new ErrorDetails();
		
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(login.getMessage());
		error.setDetails(req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.BAD_REQUEST);		
	}
	
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ErrorDetails> customerExceptionhandler(CustomerException cust,WebRequest req){
		
		ErrorDetails error = new ErrorDetails();
		
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(cust.getMessage());
		error.setDetails(req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.BAD_REQUEST);		
	}
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<ErrorDetails> productExceptionhandler(ProductException pro,WebRequest req){
		
		ErrorDetails error = new ErrorDetails();
		
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(pro.getMessage());
		error.setDetails(req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.BAD_REQUEST);		
	}
	
	@ExceptionHandler(CartException.class)
	public ResponseEntity<ErrorDetails> productExceptionhandler(CartException cart,WebRequest req){
		
		ErrorDetails error = new ErrorDetails();
		
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(cart.getMessage());
		error.setDetails(req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.BAD_REQUEST);		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> otherNotfoundExceptionhandler(Exception e,WebRequest req){
		
		ErrorDetails error = new ErrorDetails();
		
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(e.getMessage());
		error.setDetails(req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.BAD_REQUEST);		
	}
	
	
}
