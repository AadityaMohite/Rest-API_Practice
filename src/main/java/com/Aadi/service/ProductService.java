package com.Aadi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Gatherer.Integrator;

import org.springframework.stereotype.Service;

import com.Aadi.dto.ProductDto;
import com.Aadi.entity.Product;


public interface ProductService {

	
	Product getproductsByID(Integer id);
	
	List<Product> getAllproducts();
	
	String saveProduct(ProductDto productdto);
	
	List<Product> getproductByname(String name);
	
	List<Product> getproductByquantity(Integer quantity);
	
   List<Product>	getproductByprice(Double price);
   
    String deleteproductByid(Integer id);
    
    String updateproduct(Integer id,Product product);
	
}
