package com.Olxadvertise.advertiseController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Olxadvertise.dto.AdvertiseDTO;
import com.Olxadvertise.service.AdvertiseService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@CrossOrigin(origins="*")
@RequestMapping(value="/advertise")
public class AdvertiseController {
	
	@Autowired
	AdvertiseService advertiseService;
	
	
	@GetMapping(value="/advertise", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<AdvertiseDTO> getAllAdvertises() {
		return advertiseService.getAllAdvertises();
	}

	@GetMapping(value="/advertise/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<AdvertiseDTO> getAdvertisesById(@PathVariable("id") String username) {
		return advertiseService.getAllAdvertisesByUsername(username);
	}

	@PostMapping(value="/advertise", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdvertiseDTO> createNewAdvertise(@RequestBody AdvertiseDTO advertiseDto, @RequestHeader("Authorization") String authToken) {
		AdvertiseDTO advertiseDTO = this.advertiseService.createNewAdvertise(advertiseDto, authToken);
		return new ResponseEntity<AdvertiseDTO>(advertiseDTO, HttpStatus.OK);
	}
	
	
	/*
	 * @DeleteMapping(value="/user/advertise/{postId}"
	 * ,produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	 * 
	 * @ApiOperation(value="Delete user logged in Advertisements",
	 * notes=" This deletes all advertisements by Logged in user") public
	 * ResponseEntity<Advertise> DeleteAdvertisePost(@PathVariable("postID") int
	 * Id,@RequestHeader("auth-Token")String authToken) { if
	 * (authToken.equals("AF67RE")) { for(Advertise advertise:advertises) {
	 * if(advertise.getId()==Id) advertises.remove(Id);
	 * 
	 * return new ResponseEntity(true,HttpStatus.OK); }} return new
	 * ResponseEntity(false,HttpStatus.OK); }
	 * 
	 * 
	 * @GetMapping(value="/user/advertise" ,produces=
	 * {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	 * 
	 * @ApiOperation(value="Advertisements by user logged in",
	 * notes=" This returns all advertisements by username") public
	 * ResponseEntity<Advertise>
	 * getAdvertiseByUser(@ApiParam(value="Logged in user") @PathVariable("user")
	 * String username,@RequestHeader("auth-Token")String authToken) { if
	 * (authToken.equals("AF67RE")) { for(Advertise advertise:advertises) {
	 * if(advertise.getUserName().equals(username)) return new
	 * ResponseEntity<Advertise>(HttpStatus.OK); } }
	 * 
	 * return new ResponseEntity<Advertise>(HttpStatus.BAD_REQUEST); }
	 * 
	 * 
	 * @GetMapping(value="/advertise/{postID}"
	 * ,produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	 * 
	 * @ApiOperation(value="Search Advertisement By post id",
	 * notes=" This returns advertisement by post Id") public
	 * ResponseEntity<Advertise>
	 * getAdvertiseById(@ApiParam(value="enter the post Id") @PathVariable("postID")
	 * int Id,@RequestHeader("auth-Token")String authToken) { if
	 * (authToken.equals("AF67RE")) { for(Advertise advertise:advertises) {
	 * if(advertise.getId()==Id) return new
	 * ResponseEntity<Advertise>(HttpStatus.OK); } }
	 * 
	 * return new ResponseEntity<Advertise>(HttpStatus.BAD_REQUEST); }
	 * 
	 * @GetMapping(value="/advertise/search/filtercriteria"
	 * ,produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	 * 
	 * @ApiOperation(value="Search Advertisement by Filter ",
	 * notes=" This returns all filtered advertisements") public
	 * ResponseEntity<Advertise>
	 * getAdvertiseByFilter(@ApiParam(value="Add filter Criteria") @PathVariable(
	 * "filter-criteria") String filtercriteria) {
	 * 
	 * if (filtercriteria!=null) {
	 * 
	 * return new ResponseEntity<Advertise>(HttpStatus.OK); } return new
	 * ResponseEntity<Advertise>(HttpStatus.BAD_REQUEST); }
	 * 
	 * @GetMapping(value="/advertise/search"
	 * ,produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	 * 
	 * @ApiOperation(value="Search advertisement by SerachText",
	 * notes=" This returns all advertisement by search text") public
	 * ResponseEntity<Advertise>
	 * getAdvertiseBySearchText(@ApiParam(value="enter the search text"
	 * ) @PathVariable("search-text") String searchText) { if (searchText!=null) {
	 * 
	 * return new ResponseEntity<Advertise>(HttpStatus.OK); } return new
	 * ResponseEntity<Advertise>(HttpStatus.BAD_REQUEST); }
	 * 
	 * 
	 * 
	 * 
	 * @GetMapping(value="/advertise"
	 * ,produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	 * 
	 * @ApiOperation(value="Returns all Advertisements",
	 * notes=" This returns all advertisements") public ResponseEntity<Advertise>
	 * getAllAdvertise(@RequestHeader("auth-Token")String authToken) { if
	 * (authToken.equals("AF67RE")) {
	 * 
	 * return new ResponseEntity<Advertise>(HttpStatus.OK); } return new
	 * ResponseEntity<Advertise>(HttpStatus.BAD_REQUEST); }
	 * 
	 * @PostMapping(value="/advertise",
	 * consumes={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
	 * produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	 * 
	 * @ApiOperation(value="Add the new Advertisement",
	 * notes="Returns added advertise ") public ResponseEntity<Advertise>
	 * addnewAdvertise(@RequestBody Advertise
	 * advertise,@RequestHeader("auth-Token")String authToken) { if
	 * (authToken.equals("AF67RE")) { String date=new
	 * SimpleDateFormat("yyyy-mm-dd").format(Calendar.getInstance().getTime());
	 * advertise.setId(++lastUpdatedAdvertise); advertises.add(advertise);
	 * advertise.setCreatedDate(date); advertise.setModifieddate(date);
	 * advertise.setUserName("Pratibha"); advertise.setStatus("OPEN"); return new
	 * ResponseEntity<Advertise>(HttpStatus.OK); } return new
	 * ResponseEntity<Advertise>(HttpStatus.BAD_REQUEST); }
	 * 
	 * @PutMapping(value="/advertise/{id}",produces={MediaType.
	 * APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	 * 
	 * @ApiOperation(value="Update the advertise by given id",
	 * notes="Returns updated Advertis") public ResponseEntity<Advertise>
	 * updateadvertise(@RequestBody Advertise
	 * advertise, @ApiParam(value="Enter the Id to be updated") @PathVariable("id")
	 * int id,@RequestHeader("auth-Token")String authToken) { if
	 * (authToken.equals("AF67RE")) { String date=new
	 * SimpleDateFormat("yyyy-mm-dd").format(Calendar.getInstance().getTime());
	 * for(Advertise myadvertise: advertises) { if(myadvertise.getId()==id) {
	 * myadvertise.setTitle(advertise.getTitle());
	 * myadvertise.setPrice(advertise.getPrice());
	 * myadvertise.setCategoryId(advertise.getCategoryId());
	 * myadvertise.setStatusId(advertise.getStatusId());
	 * myadvertise.setDescription(advertise.getDescription());
	 * myadvertise.setModifieddate(date);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * return new ResponseEntity<Advertise>(HttpStatus.OK); } return new
	 * ResponseEntity<Advertise>(HttpStatus.BAD_REQUEST); }
	 * 
	 * static List<Advertise> advertises=new ArrayList<>(); static int
	 * lastUpdatedAdvertise=0;
	 */
}
