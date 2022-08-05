package com.example.demo.access;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bs.model.DBCart;

@Repository
public interface CartRepository extends JpaRepository<DBCart, Integer>{

}
