package com.Olxlogin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.Olxlogin.Entity.UserEntity;
import com.Olxlogin.repo.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<UserEntity> userEntityList=new ArrayList<>();
		if(userEntityList==null ||userEntityList.size()==0) {
			throw new UsernameNotFoundException(username);
		}else {
			UserEntity userEntity=new UserEntity();
			List<GrantedAuthority> authorities=new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(userEntity.getRoles()));
			User user=new User(userEntity.getUserName(),userEntity.getPassword(),authorities);
			return user;
		}
		
	}

}
