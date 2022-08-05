package com.example.demo.bs.conv;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.demo.api.dto.JsonProductRequest;
import com.example.demo.api.dto.JsonProductResponse;
import com.example.demo.bs.model.DBProduct;
import com.example.demo.bs.model.DBUser;

public class ProductConverter {

	public static DBProduct toDBProduct(JsonProductRequest request, Date createdAt, Date lastUpdate, DBUser user) {
		
		return new DBProduct(request.getId(), request.getName(), request.getPrice(), request.getAmount(), createdAt, lastUpdate, user);
	}
	
	public static JsonProductRequest toJsonProductRequest(DBProduct model) {
		
		return new JsonProductRequest(model.getId(), model.getName(), model.getPrice(), model.getAmount());
	}
	
	public static JsonProductResponse toJsonProductResponse(DBProduct model) {
		
		return new JsonProductResponse(model.getId(), model.getName(), model.getPrice(), model.getAmount());
	}
	
	public static List<JsonProductResponse> toJsonProductResponseList(List<DBProduct> model) {
		
		List<JsonProductResponse> response = new ArrayList<>();
		
		model.forEach((product) -> response.add(toJsonProductResponse(product)));
		
		return response;
	}
}
