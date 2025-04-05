package com.nimap.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nimap.entities.Product;

public interface ProductService {
	Optional<Product> getProduct(int id);
	
	Page<Product> getAllProducts(Pageable pageable);
	
	Product updateProduct(int id , Product product);
	
	Product createProduct(Product product);
	
	void deleteProduct(int id);
}
