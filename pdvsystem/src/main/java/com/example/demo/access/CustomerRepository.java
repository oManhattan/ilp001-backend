package com.example.demo.access;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.bs.model.DBCustomer;

@Repository
public interface CustomerRepository extends JpaRepository<DBCustomer, Integer>{

	@Query(nativeQuery = true, value = "SELECT * FROM Customer c WHERE c.user_id = ?1")
	List<DBCustomer> getAllCustomersFromUser(int id);
	
}
