package com.example.demo.api.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name", "email", "phone"})
public class JsonCustomerResponse extends JsonCustomerRequest {

	public JsonCustomerResponse(int id, String name, String email, String phone) {
		super(id, name, email, phone);
		
	}
}
