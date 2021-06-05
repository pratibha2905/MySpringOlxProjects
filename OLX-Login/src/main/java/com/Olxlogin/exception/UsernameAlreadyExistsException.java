package com.Olxlogin.exception;

public class UsernameAlreadyExistsException extends RuntimeException {

	private String message="";
	
	public UsernameAlreadyExistsException() {
		
	}

	/**
	 * @param message
	 */
	public UsernameAlreadyExistsException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "UsernameAlreadyExistsException [message=" + message + "]";
	}
	
	
	
}
