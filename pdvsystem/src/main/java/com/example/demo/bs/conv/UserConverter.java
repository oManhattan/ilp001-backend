package com.example.demo.bs.conv;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.demo.api.dto.JsonUserRequest;
import com.example.demo.api.dto.JsonUserResponse;
import com.example.demo.bs.model.DBUser;

public class UserConverter {

	public static DBUser toDBUser(JsonUserRequest request, Date createdAt, Date lastUpdate) {
		
		return new DBUser(request.getId(), request.getName(), request.getEmail(), request.getPassword(), createdAt, lastUpdate);
	}
	
	public static JsonUserRequest toJsonUserRequest(DBUser model) {
	
		return new JsonUserRequest(model.getId(), model.getName(), model.getEmail(), model.getPassword());
	}
	
	public static JsonUserResponse toJsonUserResponse(DBUser model) {
		
		return new JsonUserResponse(model.getId(), model.getName(), model.getEmail(), model.getPassword());
	}
	
	public static List<JsonUserResponse> toJsonUserResponseList(List<DBUser> model) {
		
		List<JsonUserResponse> response = new ArrayList<>();
		
		model.forEach((user) -> response.add(toJsonUserResponse(user)));
		
		return response;
	}
}