package com.example.demo.api.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "created_at", "customer", "cart", "total_price", "paayment_method"})
public class JsonSellResponse {

	@JsonProperty("id")
	private int id;
	
	@JsonProperty("created_at")
	private Date cratedAt;
	
	@JsonProperty("customer")
	private JsonCustomerResponse customer;
	
	@JsonProperty("cart")
	private List<JsonCartResponse> cart;
	
	@JsonProperty("total_price")
	private double totalPrice;
	
	@JsonProperty("payment_method")
	private String paymentMethod;

	public JsonSellResponse(int id, Date cratedAt, JsonCustomerResponse customer, List<JsonCartResponse> cart,
			double totalPrice, String paymentMethod) {
		super();
		this.id = id;
		this.cratedAt = cratedAt;
		this.customer = customer;
		this.cart = cart;
		this.totalPrice = totalPrice;
		this.paymentMethod = paymentMethod;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCratedAt() {
		return cratedAt;
	}

	public void setCratedAt(Date cratedAt) {
		this.cratedAt = cratedAt;
	}

	public JsonCustomerResponse getCustomer() {
		return customer;
	}

	public void setCustomer(JsonCustomerResponse customer) {
		this.customer = customer;
	}

	public List<JsonCartResponse> getCart() {
		return cart;
	}

	public void setCart(List<JsonCartResponse> cart) {
		this.cart = cart;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
}
