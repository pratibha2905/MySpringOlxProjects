package com.Olxlogin.UserController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Olxlogin.dto.UserDTO;
import com.Olxlogin.service.UserService;
import com.Olxlogin.dto.AuthenticationRequest;
import com.Olxlogin.dto.RegisterRequest;
import com.Olxlogin.utils.JwtUtils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value="/user")
public class UserController {
		
	@Autowired
	UserService userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@GetMapping(value="/token/validate")
	public ResponseEntity<Boolean> isTokenValid(@RequestHeader("Authorization") String jwtToken){
		
		//1) Extract the jwtToken by removing the word "Bearer " from jwtToken string. Use substring()
				jwtToken = jwtToken.substring(7, jwtToken.length());
				
				//2) Extract username from the jwtToken using jwtUtils.extractUsername(jwtToken)
				String username = jwtUtils.extractUsername(jwtToken);
				
				//3) Extract UserDetails using UserDetailsService.loadUserByUsername(username)
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				
				//4) Validate the token using jwtUtils.validateToken(jwtToken, userDetails);
				boolean isTokenValid = jwtUtils.validateToken(jwtToken, userDetails);
				if(isTokenValid)
					return new ResponseEntity<Boolean>(true, HttpStatus.OK);
				else
					return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
	}
	
	
		@PostMapping(value="/authenticate", consumes=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<UserDTO> authenticate (@RequestBody AuthenticationRequest authRequest){
			try {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
			}catch(BadCredentialsException e) {
				throw new BadCredentialsException(authRequest.getUsername());
			}
			UserDTO user=userService.findByUsername(authRequest.getUsername());
			user.setJwtToken(jwtUtils.generateToken(authRequest.getUsername()));
			return new ResponseEntity<UserDTO>(user,HttpStatus.OK);
		}
	
	@DeleteMapping(value="/user/logout")
	@ApiOperation(value="Logsoutuser", notes=" This returns all stocks")
	public ResponseEntity<Boolean> logoutUser(@RequestHeader("auth-Token")String authToken){
		if(authToken.equals("AF67RE"))
		{
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		
	}
		return new ResponseEntity<Boolean>(true,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value="/user/{username}" , produces ={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value="Returns user by username", notes="Returns user of that username")
	public ResponseEntity<UserDTO> findByUsername(@ApiParam("UserName passed") @PathVariable("username") String userName) { // pass that id as Parameter
		return new ResponseEntity<UserDTO>(userService.findByUsername(userName), HttpStatus.OK);
	}
	
	@GetMapping(value="/user/list/{ids}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<UserDTO> findByUsernames(@PathVariable("ids") String usernames) {
		return userService.findByUsernames(usernames);
	}
	@PostMapping(value="/register", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> register(@RequestBody RegisterRequest registerRequest) throws Exception {
		return new ResponseEntity<UserDTO>(userService.registerUser(registerRequest), HttpStatus.OK);
	}
	
}