package com.example.demo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.api.dto.JsonUserRequest;
import com.example.demo.api.dto.JsonUserResponse;
import com.example.demo.bs.service.UserService;

@Controller
@RequestMapping(path = "/pdv/")
public class UserController {

	@Autowired
	UserService service;
	
	@CrossOrigin
	@GetMapping(path = "/get/user")
	public ResponseEntity<JsonUserResponse> getUserById(@RequestParam(value = "id") int id) {
		
		JsonUserResponse response = service.getUserById(id);
		
		if (response == null) {
			return new ResponseEntity<JsonUserResponse>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<JsonUserResponse>(response, HttpStatus.FOUND);
	}
	
	@CrossOrigin
	@PostMapping(path = "/post/register/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JsonUserResponse> createUser(@RequestBody JsonUserRequest request) {
		
		if (service.emailExist(request)) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		JsonUserResponse response = service.createUser(request);
		
		return new ResponseEntity<JsonUserResponse>(response, HttpStatus.ACCEPTED);
	}
	
	@CrossOrigin
	@PostMapping(path = "/post/validate/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JsonUserResponse> validateCredentials(@RequestBody JsonUserRequest request) {
		
		JsonUserResponse response = service.vlidateCredentials(request);
		
		if (response == null) {
			return new ResponseEntity<JsonUserResponse>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<JsonUserResponse>(response, HttpStatus.FOUND);
	}
	
	@CrossOrigin
	@PutMapping(path = "/put/update/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JsonUserResponse> updateUser(@RequestBody JsonUserRequest request) {
		
		JsonUserResponse response = service.updateUser(request);
		
		if (response == null) {
			return new ResponseEntity<JsonUserResponse>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<JsonUserResponse>(response, HttpStatus.ACCEPTED);
	}
	
	@CrossOrigin
	@DeleteMapping(path = "/delete/user")
	public ResponseEntity<JsonUserResponse> deleteUser(@RequestBody JsonUserRequest request) {
		
		if (service.deleteUser(request)) {
			return new ResponseEntity<JsonUserResponse>(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<JsonUserResponse>(HttpStatus.BAD_REQUEST);
		}
	}
}
