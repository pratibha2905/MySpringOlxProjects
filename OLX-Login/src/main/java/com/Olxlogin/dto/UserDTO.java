package com.Olxlogin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="This represents the user Details")
public class UserDTO {
	private int id;
	@ApiModelProperty(value="user First name")
	private String firstName;
	@ApiModelProperty(value="user last name")
	private String lastName;
	@ApiModelProperty(value="user username ")
	private String userName;
	@ApiModelProperty(value="user password ")
	private int password;
	@ApiModelProperty(value="user email")
	private String email;
	@ApiModelProperty(value="user Phone Details")
	private int phone;
	@ApiModelProperty(value="jwtToken")
	private String jwtToken; 
	
	public UserDTO() {
		
	}
	
	
	
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param userName
	 * @param email
	 * @param phone
	 * @param jwtToken
	 */
	public UserDTO(int id, String firstName, String lastName, String userName, String email, int phone,
			String jwtToken) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.jwtToken = jwtToken;
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
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phone
	 */
	public int getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	
}
