package com.moe.mvc1.controller;

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

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.moe.mvc1.ui.model.request.UserRequestModel;
import com.moe.mvc1.ui.model.response.UserRest;

@RestController
@RequestMapping("users")
public class UserController {
	
	Map <String, UserRest> users;
	
	@GetMapping
	public String getUsers (@RequestParam(value = "page", defaultValue = "1") final int page,
			@RequestParam(value = "limit") final int limit) {
		return "get users was called with page = " + page + " and limit = " + limit;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable final String userId) {
		final UserRest testclass = new UserRest();
		testclass.setFirstname("moe");
		testclass.setEmail("moe@test1.com");
		testclass.setLastname("Sultan");

		return new ResponseEntity<UserRest>(testclass, HttpStatus.OK);
	}

	@PostMapping(
			consumes = {
					MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE
			},
			produces = {
					MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE
			})
	public ResponseEntity<UserRest> createUser (@RequestBody final UserRequestModel newUser) {
		final UserRest confirmedUser = new UserRest();
		String userID = UUID.randomUUID().toString();

		confirmedUser.setFirstname(newUser.getFirstname());
		confirmedUser.setLastname(newUser.getLastname());
		confirmedUser.setEmail(newUser.getEmail());
		confirmedUser.setUserId(userID);

		if (users == null){
			users = new HashMap <String, UserRest> ();
			users.put(userID, confirmedUser);
		}
		return new ResponseEntity<UserRest>(confirmedUser, HttpStatus.OK);
	}
	
	@PutMapping
	public String updateUser () {
		return "update user called";
	}
	@DeleteMapping
	public String deleteUser () {
		return "delete user called";
	}


}
