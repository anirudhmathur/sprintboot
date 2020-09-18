package com.developerapps.app.ws.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.developerapps.app.ws.model.request.UpdateUserDetailsRequestModel;
import com.developerapps.app.ws.model.request.UserDetailsRequestModel;
import com.developerapps.app.ws.ui.model.response.UserRest;
import com.developerapps.app.ws.userservice.UserService;
import com.developerapps.app.ws.userservice.impl.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.*;;

@RestController
@RequestMapping("users")//http://localhost:8080//users
public class UserController {

	Map<String,UserRest> users;
	@Autowired
	UserService userService;
	
	@GetMapping(path="/{userId}",produces = {MediaType.APPLICATION_XML_VALUE,
												MediaType.APPLICATION_JSON_VALUE})
	public UserRest getUser(@RequestParam(value = "page",defaultValue ="1") int page,
						  @RequestParam(value = "limit") int limit,
						  @RequestParam(value = "sort",defaultValue="desc") String sort)
	{
		return null;
	}
	
	@GetMapping(path="/{userId}")
	public  ResponseEntity<UserRest> getUser(@PathVariable String userId)
	{
		if(users.containsKey(userId))
		{
			return new ResponseEntity<UserRest>(users.get(userId),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		//return "get user was called with user id" + userId;
	}
	
	@PostMapping(consumes= {MediaType.APPLICATION_XML_VALUE,
		MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_XML_VALUE,
				MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails)
	{
		UserRest returnValue = userService.createUser(userDetails);	    
		return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);
	}
	
	

	@PutMapping(path="/{userId}",consumes= {MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE})
	public UserRest updateUser(@PathVariable String userId,
							@Valid @RequestBody UpdateUserDetailsRequestModel userDetails)
	{
		UserRest storedUser = users.get(userId);
		storedUser.setFirstName(userDetails.getFirstName());
		storedUser.setLastName(userDetails.getLastName());
		users.put(userId, storedUser);
		return storedUser;
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id)
	{
		users.remove(id);
		return ResponseEntity.noContent().build();
	}
}
