package com.example.demo.bs.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.access.ProductRepository;
import com.example.demo.access.UserRepository;
import com.example.demo.api.dto.JsonProductRequest;
import com.example.demo.api.dto.JsonProductResponse;
import com.example.demo.bs.conv.ProductConverter;
import com.example.demo.bs.model.DBProduct;
import com.example.demo.bs.model.DBUser;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;

	@Autowired
	UserRepository userRepository;

	public JsonProductResponse createProduct(JsonProductRequest request, int userId) {

		Optional<DBUser> user = userRepository.findById(userId);

		if (!user.isPresent()) {
			return null;
		}

		try {
			DBProduct model = ProductConverter.toDBProduct(request, new Date(), new Date(), user.get());
			return ProductConverter.toJsonProductResponse(repository.save(model));
		} catch (Exception e) {
			return null;
		}
	}

	public List<JsonProductResponse> getAllProductsFromUser(int userId) {

		List<DBProduct> model = repository.getAllProductsFromUser(userId);

		if (model == null) {
			return null;
		}

		return ProductConverter.toJsonProductResponseList(model);
	}

	public JsonProductResponse updateProduct(JsonProductRequest request) {

		Optional<DBProduct> model = repository.findById(request.getId());

		if (!model.isPresent()) {
			return null;
		}

		DBProduct newModel = model.get();

		newModel.setName(request.getName());
		newModel.setPrice(request.getPrice());
		newModel.setAmount(request.getAmount());
		newModel.setLastUpdate(new Date());

		try {
			return ProductConverter.toJsonProductResponse(repository.save(newModel));
		} catch (Exception e) {
			return null;
		}
	}

	public boolean deleteProduct(JsonProductRequest request) {

		Optional<DBProduct> model = repository.findById(request.getId());

		if (!model.isPresent()) {
			return false;
		}

		try {
			repository.delete(model.get());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
