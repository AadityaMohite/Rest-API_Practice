package com.Aadi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Gatherer.Integrator;

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
		product.setMfgDate(productdto.getMfgDate());
		product.setExpDate(productdto.getExpDate());
		 
		          productRepository.save(product);
		 
		 
		return "Save Product Sucessfully";
	 }

	 @Override
	 public Product getproductsByID(Integer id) {
		
		Optional<Product> op =    productRepository.findById(id);
		
		if(op.isPresent()) {
		Product product = op.get();
		return product;
		}
		
		throw new ProductNotFoundException("Product Not Found at this id");
	 }

	 @Override
	 public List<Product> getproductByname(String name) {
		
	List<Product> product = 	 productRepository.findByName(name);
		 
	if(product!=null) {
		return product;
	}
		 
		 
		 
	   throw new ProductNotFoundException("Product is not found by this name");
	 }

	 @Override
	 public List<Product> getproductByquantity(Integer quantity) {
		  List<Product> quantityList =     productRepository.findByQuantity(quantity);
		  
		  if(quantityList!=null) {
			  return quantityList;
		  }
		  
		throw new ProductNotFoundException("Product is not found by this quantity");
	 }

	 @Override
	 public List<Product> getproductByprice(Double price) {
		
		List<Product> products= productRepository.findByPrice(price);
		 
		 if(products!=null) {
			 return products;
		 }
		throw new ProductNotFoundException("Product is not found at this Price");
	 }

	 @Override
	 public String deleteproductByid(Integer id) {
		
		 if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
		}
		 
		 return "Deleted Successfully";
		 
		 
	 }

	 @Override
	 public String updateproduct(Integer id, Product product) {
		
		           Optional<Product> existing =    productRepository.findById(id);
		           
		           
		           if(existing.isPresent()) {
		        	   
		        	    Product product2  =    existing.get();
		        	   
		        	    		product2.setName(product.getName());
		        	            product2.setPrice(product.getPrice());
		        	            product2.setCategory(product.getCategory());
		        	            product2.setQuantity(product.getQuantity());
		        	            product2.setExpDate(product.getExpDate());
		        	            product2.setMfgDate(product.getMfgDate());
		        	   
		        	            productRepository.save(product2);
		           }
		 
		 
		 return "Updated Successfully";
		               
	 }
	
	
	
	

}
