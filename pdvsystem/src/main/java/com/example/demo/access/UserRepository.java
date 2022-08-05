package com.example.demo.access;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bs.model.DBUser;

@Repository
public interface UserRepository extends JpaRepository<DBUser, Integer> {

	DBUser findByEmail(String email);
	
}
