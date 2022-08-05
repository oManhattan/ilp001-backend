package com.example.demo.bs.conv;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.api.dto.JsonSellRequest;
import com.example.demo.api.dto.JsonSellResponse;
import com.example.demo.bs.model.DBCart;
import com.example.demo.bs.model.DBCustomer;
import com.example.demo.bs.model.DBSell;
import com.example.demo.bs.model.DBUser;

public class SellConverter {

	public static DBSell toDBSell(JsonSellRequest request, DBUser user, DBCustomer customer, List<DBCart> cart) {
		
		return new DBSell(0, user, customer, cart, request.getTotalPrice(), request.getPaymentMethod(), request.getCratedAt());
	}
	
	public static JsonSellRequest toJsonSellRequest(DBSell model) {
		
		return new JsonSellRequest(model.getId(), model.getCratedAt(), CustomerConverter.toJsonCustomerRequest(model.getCustomer()), CartConverter.toJsonCartRequestList(model.getCart()), model.getTotalPrice(), model.getPaymentMethod());
	}
	
	public static JsonSellResponse toJsonSellResponse(DBSell model) {
		
		return new JsonSellResponse(model.getId(), model.getCratedAt(), CustomerConverter.toJsonCustomerResponse(model.getCustomer()), CartConverter.toJsonCartResponseList(model.getCart()), model.getTotalPrice(), model.getPaymentMethod());
	}
	
	public static List<JsonSellResponse> toJsonSellResponselist(List<DBSell> model) {
		
		List<JsonSellResponse> response = new ArrayList<>();
		
		model.forEach((sell) -> response.add(toJsonSellResponse(sell)));
		
		return response;
	}
}
