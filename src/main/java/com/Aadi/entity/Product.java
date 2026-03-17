package com.Aadi.entity;



import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="products")
public class Product {
    
	
   @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	

	private String name;
	
	
	
	private Double price;
	
	
	
	private Integer quantity;
	
	
	
	
	private String category;
	
	
}
