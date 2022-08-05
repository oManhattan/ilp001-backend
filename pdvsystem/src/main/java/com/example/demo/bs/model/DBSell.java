package com.example.demo.bs.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SELL")
public class DBSell {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@ManyToOne(targetEntity = DBUser.class, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private DBUser user;
	
	@ManyToOne(targetEntity = DBCustomer.class, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private DBCustomer customer;
	
	@OneToMany(targetEntity = DBCart.class, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private List<DBCart> cart;
	
	@Column(name = "TOTAL_PRICE")
	private double totalPrice;
	
	@Column(name = "PAYMENT_METHOD")
	private String paymentMethod;
	
	@Column(name = "CRATED_AT")
	private Date cratedAt;
	
	public DBSell() {
		
	}

	public DBSell(int id, DBUser user, DBCustomer customer, List<DBCart> cart, double totalPrice, String paymentMethod,
			Date cratedAt) {
		super();
		this.id = id;
		this.user = user;
		this.customer = customer;
		this.cart = cart;
		this.totalPrice = totalPrice;
		this.paymentMethod = paymentMethod;
		this.cratedAt = cratedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DBUser getUser() {
		return user;
	}

	public void setUser(DBUser user) {
		this.user = user;
	}

	public DBCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(DBCustomer customer) {
		this.customer = customer;
	}

	public List<DBCart> getCart() {
		return cart;
	}

	public void setCart(List<DBCart> cart) {
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

	public Date getCratedAt() {
		return cratedAt;
	}

	public void setCratedAt(Date cratedAt) {
		this.cratedAt = cratedAt;
	}

	@Override
	public String toString() {
		return "DBSell [id=" + id + ", user=" + user + ", customer=" + customer + ", cart=" + cart + ", totalPrice="
				+ totalPrice + ", paymentMethod=" + paymentMethod + ", cratedAt=" + cratedAt + "]";
	}
	
	
}
