package com.example.demo.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "product", "amount"})
public class JsonCartResponse {

	@JsonProperty("id")
	private int id;
	
	@JsonProperty("product")
	private JsonProductResponse product;
	
	@JsonProperty("amount")
	private int amount;

	public JsonCartResponse(int id, JsonProductResponse product, int amount) {
		super();
		this.id = id;
		this.product = product;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JsonProductResponse getProduct() {
		return product;
	}

	public void setProduct(JsonProductResponse product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
