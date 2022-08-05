package com.example.demo.api.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name", "email"})
public class JsonUserResponse extends JsonUserRequest {

	public JsonUserResponse(int id, String name, String email, String password) {
		super(id, name, email, password);
		
	}
}
