package com.Aadi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Aadi.Repository.ProductRepository;
import com.Aadi.dto.ProductDto;
import com.Aadi.entity.Product;
import com.Aadi.exception.ProductNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	ProductRepository productRepository;
	
	
	

//	 @Override
//	 public Product getproductsByID(Integer id) {
//		ArrayList<Product> products = getallProducts();
//		
//		for (Product product : products) {
//			if (product.getId()==id) {
//				return product;
//			}
//		}
//		 throw new ProductNotFoundException("Product Not Found at this id");
//	 }
	
	 
	 public List<Product> getAllproducts() {
		 
	List<Product>   products =	 productRepository.findAll();
	
	
	if(products.isEmpty()) {
		throw new ProductNotFoundException("Product Not Found at this id");
	}
		 
	return products;
		 
		 
	 }

	 @Override
	 public String saveProduct(ProductDto productdto) {
		 
		 Product product = new Product();
		 
		 
		 product.setName(productdto.getName());
		 product.setPrice(productdto.getPrice());
		 product.setCategory(productdto.getCategory());
		 product.setQuantity(productdto.getQuantity());
		 
		          productRepository.save(product);
		 
		 
		return "Save Product Sucessfully";
	 }

	 @Override
	 public Product getproductsByID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	 }
	
	
	
	

}
