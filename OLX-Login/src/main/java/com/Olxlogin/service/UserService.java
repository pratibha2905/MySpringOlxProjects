package com.Olxlogin.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.Olxlogin.dto.RegisterRequest;
import com.Olxlogin.dto.UserDTO;

import io.swagger.annotations.ApiParam;

public interface UserService {

	
	public UserDTO registerUser(RegisterRequest registerRequest);
	List<UserDTO> findByUsernames(String usernames);
	UserDTO findByUsername(String username);
	
	/*
	 * Boolean logoutUser(String authToken); UserDTO getuserById(int userName) ;
	 * UserDTO RegisterUser( UserDTO user ,String authToken); UserDTO userLogin(
	 * UserDTO user ,String username, int password);
	 */	
}
