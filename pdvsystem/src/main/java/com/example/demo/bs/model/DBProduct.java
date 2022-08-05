package com.example.demo.bs.model;

import java.util.Date;

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
@Table(name = "PRODUCT")
public class DBProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PRICE")
	private double price;
	
	@Column(name = "AMOUNT")
	private int amount;
	
	@Column(name = "CREATED_AT")
	private Date createdAt;
	
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;
	
	@ManyToOne(targetEntity = DBUser.class, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private DBUser user;

	public DBProduct() {
		
	}
	
	public DBProduct(int id, String name, double price, int amount, Date createdAt, Date lastUpdate, DBUser user) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.createdAt = createdAt;
		this.lastUpdate = lastUpdate;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public DBUser getUser() {
		return user;
	}

	public void setUser(DBUser user) {
		this.user = user;
	}
}
