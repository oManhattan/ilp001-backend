package com.example.demo.access;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.bs.model.DBProduct;

@Repository
public interface ProductRepository extends JpaRepository<DBProduct, Integer>{

	@Query(nativeQuery = true, value = "SELECT * FROM Product p WHERE p.user_id = ?1")
	List<DBProduct> getAllProductsFromUser(int id);
	
}
