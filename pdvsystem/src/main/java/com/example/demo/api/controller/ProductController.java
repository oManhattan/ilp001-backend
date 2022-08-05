package com.example.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.api.dto.JsonProductRequest;
import com.example.demo.api.dto.JsonProductResponse;
import com.example.demo.bs.service.ProductService;

@Controller
@RequestMapping(path = "/pdv/")
public class ProductController {

	@Autowired
	ProductService service;
	
	@CrossOrigin
	@PostMapping(path = "/post/register/product")
	public ResponseEntity<JsonProductResponse> createProduct(@RequestParam(value = "userid") int userId, @RequestBody JsonProductRequest request) {
		
		JsonProductResponse response = service.createProduct(request, userId);
		
		if (response == null) {
			return new ResponseEntity<JsonProductResponse>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<JsonProductResponse>(response, HttpStatus.CREATED);
	}
	
	
	@CrossOrigin
	@GetMapping(path = "/get/list/product")
	public ResponseEntity<List<JsonProductResponse>> getAllProductsFromUser(@RequestParam(value = "userid") int userId) {
		
		List<JsonProductResponse> response = service.getAllProductsFromUser(userId);
		
		if (response == null) {
			return new ResponseEntity<List<JsonProductResponse>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<JsonProductResponse>>(response, HttpStatus.FOUND);
	}
	
	@CrossOrigin
	@PutMapping(path = "/put/update/product")
	public ResponseEntity<JsonProductResponse> updateProduct(@RequestBody JsonProductRequest request) {
		
		JsonProductResponse response = service.updateProduct(request);
		
		if (response == null) {
			return new ResponseEntity<JsonProductResponse>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<JsonProductResponse>(response, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<Boolean> deleteProduct(@RequestBody JsonProductRequest request) {
		
		if (service.deleteProduct(request)) {
			return new ResponseEntity<Boolean>(HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
	}
}
