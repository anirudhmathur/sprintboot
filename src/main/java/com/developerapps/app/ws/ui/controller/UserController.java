package com.developerapps.app.ws.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")//http://localhost:8080//users
public class UserController {


	@GetMapping
	public String getUser(@RequestParam(value = "page") int page,@RequestParam(value = "limit") int limit )
	{
		return "get user was called with user id" +limit + page;
	}
	
	@GetMapping(path="/{userId}")
	public String getUser(@PathVariable String userId)
	{
		return "get user was called with user id" + userId;
	}
	
	@PostMapping
	public String createUser()
	{
		return "create user was called";
	}
	
	
	@PutMapping
	public String updateUser()
	{
		return "update user was called";
	}
	
	@DeleteMapping
	public String deleeUser()
	{
		return "delte user was called";
	}
}
