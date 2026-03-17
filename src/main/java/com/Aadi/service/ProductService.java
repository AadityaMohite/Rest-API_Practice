package com.Aadi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Aadi.dto.ProductDto;
import com.Aadi.entity.Product;


public interface ProductService {

	
	Product getproductsByID(Integer id);
	
	List<Product> getAllproducts();
	
	String saveProduct(ProductDto productdto);
	
}
