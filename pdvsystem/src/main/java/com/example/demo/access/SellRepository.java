package com.example.demo.access;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.bs.model.DBSell;

@Repository
public interface SellRepository extends JpaRepository<DBSell, Integer>{
 
	@Query(nativeQuery = true, value = "SELECT * FROM Sell s WHERE s.user_id = ?1")
	List<DBSell> getAllSellsFromUser(int userId);
	
}
