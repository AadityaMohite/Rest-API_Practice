package com.Aadi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Aadi.entity.Product;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByName(String name);
	List<Product> findByQuantity(Integer quantity);
	List<Product> findByPrice(Double price);
}
