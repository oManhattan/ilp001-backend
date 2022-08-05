package com.example.demo.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "product", "amount"})
public class JsonCartRequest {

	@JsonProperty("id")
	private int id;
	
	@JsonProperty("product")
	private JsonProductRequest product;
	
	@JsonProperty("amount")
	private int amount;

	public JsonCartRequest(int id, JsonProductRequest product, int amount) {
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

	public JsonProductRequest getProduct() {
		return product;
	}

	public void setProduct(JsonProductRequest product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
