package com.example.demo.bs.conv;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.demo.api.dto.JsonCustomerRequest;
import com.example.demo.api.dto.JsonCustomerResponse;
import com.example.demo.bs.model.DBCustomer;
import com.example.demo.bs.model.DBUser;

public class CustomerConverter {

	public static DBCustomer toDBCustomer(JsonCustomerRequest request, Date createdAt, Date lastUpdate, DBUser user) {
	
		return new DBCustomer(request.getId(), request.getName(), request.getEmail(), request.getPhone(), createdAt, lastUpdate, user);
	}
	
	public static JsonCustomerRequest toJsonCustomerRequest(DBCustomer model) {
		
		return new JsonCustomerRequest(model.getId(), model.getName(), model.getEmail(), model.getPhone());
	}
	
	public static JsonCustomerResponse toJsonCustomerResponse(DBCustomer model) {
		
		return new JsonCustomerResponse(model.getId(), model.getName(), model.getEmail(), model.getPhone());
	}
	
	public static List<JsonCustomerResponse> toJsonCustomerResponseList(List<DBCustomer> model) {
		
		List<JsonCustomerResponse> response = new ArrayList<>();
		
		model.forEach((customer) -> response.add(toJsonCustomerResponse(customer)));
		
		return response;
	}
}
