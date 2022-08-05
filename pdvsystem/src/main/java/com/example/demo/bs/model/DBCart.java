package com.example.demo.bs.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CART")
public class DBCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@ManyToOne(targetEntity = DBProduct.class, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private DBProduct product;
	
	@Column(name = "AMOUNT")
	private int amount;

	public DBCart(int id, DBProduct product, int amount) {
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

	public DBProduct getProduct() {
		return product;
	}

	public void setProduct(DBProduct product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
