package com.Aadi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Aadi.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	
}
