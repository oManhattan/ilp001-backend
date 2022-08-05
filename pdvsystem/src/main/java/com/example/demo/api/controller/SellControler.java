package com.example.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.api.dto.JsonSellRequest;
import com.example.demo.api.dto.JsonSellResponse;
import com.example.demo.bs.service.SellService;

@Controller
@RequestMapping(path = "/pdv/")
public class SellControler {

	@Autowired
	SellService service;
	
	@CrossOrigin
	@PostMapping(path = "/post/register/sell")
	public ResponseEntity<JsonSellResponse> createSell(@RequestParam(value = "userid") int userId, @RequestBody JsonSellRequest request) {
		
		JsonSellResponse response = service.createSell(request, userId);
		
		if (response != null) {
			return new ResponseEntity<JsonSellResponse>(response, HttpStatus.CREATED); 
		}
		
		return new ResponseEntity<JsonSellResponse>(HttpStatus.BAD_REQUEST);
	}
	
	@CrossOrigin
	@GetMapping(path = "/get/list/sell")
	public ResponseEntity<List<JsonSellResponse>> getAllSellsFromUser(@RequestParam(value = "userid") int userId) {
		
		List<JsonSellResponse> response = service.getAllSellsFromUser(userId);
		
		if (response != null) {
			return new ResponseEntity<List<JsonSellResponse>>(response, HttpStatus.FOUND);
		}
		
		return new ResponseEntity<List<JsonSellResponse>>(HttpStatus.NOT_FOUND);
	}
}
