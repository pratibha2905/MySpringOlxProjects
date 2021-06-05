package com.Olxlogin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Olxlogin.Entity.UserEntity;
import com.Olxlogin.dto.RegisterRequest;
import com.Olxlogin.dto.UserDTO;
import com.Olxlogin.exception.UsernameAlreadyExistsException;
import com.Olxlogin.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	

	@Autowired
	private UserRepository userRepository;
	
	

	@Override
	public UserDTO registerUser(RegisterRequest registerRequest) {
		List<UserEntity> userEntityList = userRepository.findByUserName(registerRequest.getUsername());
		if(userEntityList==null || userEntityList.size()==0) {
			throw new UsernameAlreadyExistsException(registerRequest.getUsername());
		}
		UserEntity userEntity = new UserEntity();
		userEntity.setActive(true);
		userEntity.setFirstName(registerRequest.getFirstname());
		userEntity.setLastName(registerRequest.getLastname());
		userEntity.setPassword(registerRequest.getPassword());
		userEntity.setRoles("USER");
		userEntity.setUserName(registerRequest.getUsername());
		userEntity = userRepository.save(userEntity);
		UserDTO userDto = new UserDTO();
		userDto.setFirstName(userEntity.getFirstName());
		userDto.setLastName(userEntity.getLastName());
		userDto.setUserName(userEntity.getUserName());
		return userDto;
	}

	@Override
	public UserDTO findByUsername(String usernames) {
		List<UserEntity> userEntityList=new ArrayList<>();
		if(userEntityList==null || userEntityList.size()==0) {
			return null;
		}
		//UserEntity userEntity = opUserEntity.isPresent() ? opUserEntity.get() : null;
		UserEntity userEntity = userEntityList.get(0);
		UserDTO userDto = new UserDTO();
		userDto.setFirstName(userEntity.getFirstName());
		userDto.setLastName(userEntity.getLastName());
		userDto.setUserName(userEntity.getUserName());
		return userDto;
	}

	@Override
	public List<UserDTO> findByUsernames(String usernames) {
		String usernameArray[] = usernames.split(",");
		List<UserDTO> userList = new ArrayList<>();
		for(int i=0; i<usernameArray.length; i++) {
			if(usernameArray[i]!=null && usernameArray[i].trim().length()>0) {
				userList.add(this.findByUsername(usernameArray[i]));
			}
		}
		return userList;
	}}




