package com.example.demo.api.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name", "price", "amount"})
public class JsonProductResponse extends JsonProductRequest {

	public JsonProductResponse(int id, String name, double price, int amount) {
		super(id, name, price, amount);
		
	}
}
