package com.example.demo.bs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.access.CartRepository;
import com.example.demo.access.CustomerRepository;
import com.example.demo.access.ProductRepository;
import com.example.demo.access.SellRepository;
import com.example.demo.access.UserRepository;
import com.example.demo.api.dto.JsonCartRequest;
import com.example.demo.api.dto.JsonSellRequest;
import com.example.demo.api.dto.JsonSellResponse;
import com.example.demo.bs.conv.CartConverter;
import com.example.demo.bs.conv.SellConverter;
import com.example.demo.bs.model.DBCart;
import com.example.demo.bs.model.DBCustomer;
import com.example.demo.bs.model.DBProduct;
import com.example.demo.bs.model.DBSell;
import com.example.demo.bs.model.DBUser;

@Service
public class SellService {

	@Autowired
	SellRepository sellRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	private DBUser getUserById(int id) {
		
		Optional<DBUser> user = userRepository.findById(id);
		
		if (user.isPresent()) {
			return user.get();
		}
		
		return null;
	}
	
	private DBCustomer getCustomerById(int id) {
		
		Optional<DBCustomer> customer = customerRepository.findById(id);
		
		if (customer.isPresent()) {
			return customer.get();
		}
		
		return null;
	}
	
	private DBProduct getProductById(int id) {
		
		Optional<DBProduct> product = productRepository.findById(id);
		
		if (product.isPresent()) {
			return product.get();
		}
		
		return null;
	}
	
	private List<DBCart> getDBCartList(List<JsonCartRequest> requestList) {
		
		List<DBCart> model = new ArrayList<>();
		
		for(JsonCartRequest request : requestList) {
			
			DBProduct product = getProductById(request.getProduct().getId());
			
			if (product == null) {
				return null;
			}
			
			model.add(CartConverter.toDBCart(request, product));
		}
		
		return model;
	}
	
	public JsonSellResponse createSell(JsonSellRequest request, int userId) {
		
		System.out.println("Entrei na func");
		DBUser user = getUserById(userId);
		System.out.println("Consegui o usuario " + user == null);
		DBCustomer customer = getCustomerById(request.getCustomer().getId());
		System.out.println("Consegui o cliente " + customer == null);
		List<DBCart> cart = getDBCartList(request.getCart());
		System.out.println("Consegui converter o carrinho " + cart == null);
		DBSell model = SellConverter.toDBSell(request, user, customer, cart);
		System.out.println("Consegui fazer o objeto " + model == null);
		model.setCratedAt(new Date());
		
		System.out.println(model.toString());
		
		try {
			return SellConverter.toJsonSellResponse(sellRepository.save(model));
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<JsonSellResponse> getAllSellsFromUser(int userId) { 
		
		List<DBSell> model = sellRepository.getAllSellsFromUser(userId);
		
		if (model != null) {
			return SellConverter.toJsonSellResponselist(model);
		}
		
		return null;
	}
}
