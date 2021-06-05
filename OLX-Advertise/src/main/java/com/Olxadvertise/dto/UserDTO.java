package com.Olxadvertise.dto;

public class UserDTO {
	private String username;
	private String firstName;
	private String lastName;
	private String jwtToken;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the jwtToken
	 */
	public String getJwtToken() {
		return jwtToken;
	}
	/**
	 * @param jwtToken the jwtToken to set
	 */
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	
	
	
	/**
	 * @param username
	 * @param firstName
	 * @param lastName
	 * @param jwtToken
	 */
	public UserDTO(String username, String firstName, String lastName, String jwtToken) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.jwtToken = jwtToken;
	}
	public UserDTO() {
		
	}
	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", jwtToken="
				+ jwtToken + "]";
	}
	
	
}
