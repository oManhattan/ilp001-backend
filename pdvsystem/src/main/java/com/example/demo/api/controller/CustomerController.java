package com.example.demo.api.controller;
import java.util.List;

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

import com.example.demo.api.dto.JsonCustomerRequest;
import com.example.demo.api.dto.JsonCustomerResponse;
import com.example.demo.bs.service.CustomerService;

@Controller
@RequestMapping(path = "/pdv/")
public class CustomerController {

	@Autowired
	CustomerService service;
	
	@CrossOrigin
	@PostMapping(path = "/post/register/customer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JsonCustomerResponse> createCustomer(@RequestParam(value = "userid") int id, @RequestBody JsonCustomerRequest request) {
		
		JsonCustomerResponse response = service.createCustomer(request, id);
		
		if (response == null) { 
			return new ResponseEntity<JsonCustomerResponse>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<JsonCustomerResponse>(response, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@GetMapping(path = "/get/customer/list")
	public ResponseEntity<List<JsonCustomerResponse>> customerListFromUser(@RequestParam(value = "userid") int id) {
		
		List<JsonCustomerResponse> response = service.getAllCustomersFromUser(id);
		
		if (response == null) {
			return new ResponseEntity<List<JsonCustomerResponse>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<JsonCustomerResponse>>(response, HttpStatus.FOUND);
	}
	
	@CrossOrigin
	@PutMapping(path = "put/update/customer")
	public ResponseEntity<JsonCustomerResponse> updateCustomer(@RequestBody JsonCustomerRequest request) {
		
		JsonCustomerResponse response = service.updateCustomer(request);
		
		if (response == null) {
			return new ResponseEntity<JsonCustomerResponse>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<JsonCustomerResponse>(response, HttpStatus.ACCEPTED);
	}
	
	@CrossOrigin
	@DeleteMapping(path = "delete/customer")
	public ResponseEntity<JsonCustomerResponse> deleteCustomer(@RequestBody JsonCustomerRequest request) {
		
		if (service.deleteCustomer(request)) {
			return new ResponseEntity<JsonCustomerResponse>(HttpStatus.ACCEPTED);
		} 
		
		return new ResponseEntity<JsonCustomerResponse>(HttpStatus.BAD_REQUEST);
	}
}
