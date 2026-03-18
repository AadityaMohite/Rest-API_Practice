package com.Aadi.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Aadi.dto.*;
import com.Aadi.entity.Product;
import com.Aadi.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class ProductRestController {

	@Autowired
	ProductService productService;
	
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable  Integer id) {
	Product product =	productService.getproductsByID( id);
		
	if(product == null) {
		
		
		return new  ResponseEntity<Product>(product,HttpStatus.INTERNAL_SERVER_ERROR);
		
	
	}
	
	
	   return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	
	@GetMapping("/products")
	
	public ResponseEntity<List<Product>> getallproducts() {
		
		
		
		          List<Product> products  =   productService.getAllproducts();
		
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
		
		
		
	}
	
	@PostMapping("/save")
	
	public ResponseEntity<String> saveproduct(@Valid @RequestBody ProductDto productdto) {
		String msg = productService.saveProduct(productdto);
		
		System.err.println(productdto);
	
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/byname")
	public ResponseEntity<List<Product>> getproductbyname(@RequestParam String name) {
		
		       List<Product> products    =    productService.getproductByname(name);
		
		       
		       return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
		
	}
	
	@GetMapping("/byquantity")
	public ResponseEntity<List<Product>> getproductsbyquantity(@RequestParam Integer quantity){
		
		           List<Product> products     =        productService.getproductByquantity(quantity);
		           
		           return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/byprice")
	public ResponseEntity<List<Product>> getproductsByprice(@RequestParam Double price){
	List<Product> products =	productService.getproductByprice(price);
	
	return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteproductbyId(@PathVariable Integer id) {
		
		             String msg    =     productService.deleteproductByid(id);
		
		return msg;
	}
	
	
	@PutMapping("/update/{id}")
	public String updateproduct( @PathVariable  Integer id,@RequestBody Product product) {
		
		String msg = productService.updateproduct(id, product);
		
		return msg;
	}
	
	
	
	
}
