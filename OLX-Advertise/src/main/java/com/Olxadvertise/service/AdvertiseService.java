package com.Olxadvertise.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.Olxadvertise.dto.AdvertiseDTO;

import io.swagger.annotations.ApiParam;

public interface AdvertiseService {


	public List<AdvertiseDTO> getAllAdvertises();
	public List<AdvertiseDTO> getAllAdvertisesByUsername(String username);
	public AdvertiseDTO createNewAdvertise(AdvertiseDTO advertiseDto, String authToken);
	
	
	
	
	
	/*
	 * AdvertiseDTO DeleteAdvertisePost(int Id,String authToken); AdvertiseDTO
	 * getAdvertiseByUser(String username,String authToken); AdvertiseDTO
	 * getAdvertiseById(int Id,String authToken); AdvertiseDTO
	 * getAdvertiseByFilter(String filtercriteria); AdvertiseDTO
	 * getAllAdvertise(String authToken); AdvertiseDTO addnewAdvertise( AdvertiseDTO
	 * advertise,String authToken); AdvertiseDTO updateadvertise(AdvertiseDTO
	 * advertise,int id,String authToken);
	 */
		
	
	
}
