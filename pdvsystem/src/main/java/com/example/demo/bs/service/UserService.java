package com.example.demo.bs.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.access.UserRepository;
import com.example.demo.api.dto.JsonUserRequest;
import com.example.demo.api.dto.JsonUserResponse;
import com.example.demo.bs.conv.UserConverter;
import com.example.demo.bs.model.DBUser;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	public JsonUserResponse getUserById(int id) {
		
		try  {
			Optional<DBUser> model = repository.findById(id);
			return UserConverter.toJsonUserResponse(model.get());
		} catch (Exception e) {
			return null;
		}
	}
	
	public JsonUserResponse createUser(JsonUserRequest request) {
		
		DBUser model = UserConverter.toDBUser(request, new Date(), new Date());
		
		try {
			return UserConverter.toJsonUserResponse(repository.save(model));
		} catch (Exception e) {
			return null;
		}
	}
	
	public JsonUserResponse updateUser(JsonUserRequest request) {
		
		Optional<DBUser> model = repository.findById(request.getId());
		
		if (!model.isPresent()) {
			return null;
		}
		
		DBUser newModel = model.get();
		
		newModel.setName(request.getName());
		newModel.setEmail(request.getEmail());
		newModel.setPassword(request.getPassword());
		newModel.setLastUpdate(new Date());
		
		try {
			return UserConverter.toJsonUserResponse(repository.save(newModel));
		}catch (Exception e) {
			return null;
		}
	}
	
	public JsonUserResponse vlidateCredentials(JsonUserRequest request) {
		
		DBUser model = repository.findByEmail(request.getEmail());
		
		if (model == null) {
			return null;
		}
		
		if (request.getPassword().equals(model.getPassword())) {
			return UserConverter.toJsonUserResponse(model);
		}
		
		return null;
	}
	
	public boolean deleteUser(JsonUserRequest request) {
		
		Optional<DBUser> model = repository.findById(request.getId());
		
		if (!model.isPresent()) { 
			return false ; 
		}
		
		try {
			repository.delete(model.get());
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean emailExist(JsonUserRequest request) {
		
		DBUser model = repository.findByEmail(request.getEmail());
		
		return model != null;
	}
}
