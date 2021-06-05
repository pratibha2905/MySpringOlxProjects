package com.Olxmasterdata.MasterDataController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Olxmasterdata.dto.Category;
import com.Olxmasterdata.dto.Status;
import com.Olxmasterdata.service.MasterDataService;

import io.swagger.annotations.ApiOperation;


@RestController
@CrossOrigin(origins="*")
@RequestMapping(value="/advertise")
public class MasterDataController {
	
	@Autowired
	MasterDataService masterdataService;
	
	@GetMapping(value="/advertise/category" , produces ={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value="Returns list of Categories", notes=" This returns all categories")
	public List<Category> getCategory() { // pass that id as Parameter
				
		return categories;
	
}
	@GetMapping(value="/advertise/status" , produces ={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value="Returns all Status", notes=" This returns all Status")
	public List<Status> getStatus() { // pass that id as Parameter
		
		return status;
		
	
}
	static List<Category> categories=new ArrayList<>();
	static List<Status> status=new ArrayList<>();
	
}
