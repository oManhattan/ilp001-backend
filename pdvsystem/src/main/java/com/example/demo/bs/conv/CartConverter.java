package com.example.demo.bs.conv;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.api.dto.JsonCartRequest;
import com.example.demo.api.dto.JsonCartResponse;
import com.example.demo.bs.model.DBCart;
import com.example.demo.bs.model.DBProduct;

public class CartConverter {

	public static DBCart toDBCart(JsonCartRequest request, DBProduct product) {
		
		return new DBCart(request.getId(), product, request.getAmount());
	}
	
	public static JsonCartRequest toJsonCartRequest(DBCart model) {
		
		return new JsonCartRequest(model.getId(), ProductConverter.toJsonProductRequest(model.getProduct()), model.getAmount());
	}
	
	public static JsonCartResponse toJsonCartResponse(DBCart model) {
		
		return new JsonCartResponse(model.getId(), ProductConverter.toJsonProductResponse(model.getProduct()), model.getAmount());
	}
	
	public static List<JsonCartResponse> toJsonCartResponseList(List<DBCart> model) {
		
		List<JsonCartResponse> response = new ArrayList<>();
		
		model.forEach((cart) -> response.add(toJsonCartResponse(cart)));
		
		return response;
	}
	
	public static List<JsonCartRequest> toJsonCartRequestList(List<DBCart> model) {
		
		List<JsonCartRequest> request = new ArrayList<>();
		
		model.forEach((cart) -> request.add(toJsonCartRequest(cart)));
		
		return request;
	}
}
