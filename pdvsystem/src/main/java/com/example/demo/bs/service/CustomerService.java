package com.example.demo.bs.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.access.CustomerRepository;
import com.example.demo.access.UserRepository;
import com.example.demo.api.dto.JsonCustomerRequest;
import com.example.demo.api.dto.JsonCustomerResponse;
import com.example.demo.bs.conv.CustomerConverter;
import com.example.demo.bs.model.DBCustomer;
import com.example.demo.bs.model.DBUser;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	UserRepository userRepository;

	public DBUser getUser(int id) {
		Optional<DBUser> user = userRepository.findById(id);

		if (user.isPresent()) {
			return user.get();
		}
		
		return null;
	}

	public JsonCustomerResponse createCustomer(JsonCustomerRequest request, int userId) {

		DBUser user = getUser(userId);
		
		if (user == null) { 
			return null;
		}
		
		DBCustomer model = CustomerConverter.toDBCustomer(request, new Date(), new Date(), user);

		try {
			return CustomerConverter.toJsonCustomerResponse(customerRepository.save(model));
		} catch (Exception e) {
			return null;
		}
	}

	public List<JsonCustomerResponse> getAllCustomersFromUser(int userId) {
		
		DBUser model = getUser(userId);
		
		if (model == null) {
			return null;
		}
		
		List<JsonCustomerResponse> list = CustomerConverter.toJsonCustomerResponseList(customerRepository.getAllCustomersFromUser(model.getId()));
		
		return list;
	}
	
	public JsonCustomerResponse updateCustomer(JsonCustomerRequest request) {
		
		Optional<DBCustomer> model = customerRepository.findById(request.getId());
		
		if (!model.isPresent()) {
			return null;
		}
		
		DBCustomer newModel = model.get();
		
		newModel.setName(request.getName());
		newModel.setEmail(request.getEmail());
		newModel.setPhone(request.getPhone());
		newModel.setLastUpdate(new Date());
		
		try {
			return CustomerConverter.toJsonCustomerResponse(newModel);
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean deleteCustomer(JsonCustomerRequest request) {
		
		Optional<DBCustomer> model = customerRepository.findById(request.getId());
		
		if (!model.isPresent()) {
			return false;
		}
		
		try {
			customerRepository.delete(model.get());
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}
