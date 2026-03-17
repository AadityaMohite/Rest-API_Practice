package com.Aadi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public
class ProductDto{
	
	 
		
		
		@NotBlank(message = "Name is Required")
		private String name;
		
		
		@NotNull(message = "Price is Required")
		private Double price;
		
		
		@NotNull(message = "quantity is required")
		private Integer quantity;
		
		
		
		@NotBlank(message = "Category is required")
		private String category;
		
	
	
	
	
}