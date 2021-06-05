package com.Olxlogin.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value= {UsernameAlreadyExistsException.class})
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, 
          new HttpHeaders(), HttpStatus.CONFLICT, request);
	
	}

	private ResponseEntity<Object> handleExceptionInternal(RuntimeException ex, String bodyOfResponse,
			HttpHeaders httpHeaders, HttpStatus conflict, WebRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
}
