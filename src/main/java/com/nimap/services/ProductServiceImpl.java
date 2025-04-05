package com.nimap.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.entities.Product;
import com.nimap.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Optional<Product> getProduct(int id) {
		return productRepository.findById(id);
	}

	@Override
	public Product createProduct(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
		
	}



	@Override
	public Page<Product> getAllProducts(Pageable pageable) {
		
		return productRepository.findAll(pageable);
	}

	@Override
	public Product updateProduct(int id, Product product) {
		Product product2= productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product Not Found"));
		product2.setTitle(product.getTitle());
		product2.setAuthor(product.getAuthor());
		product2.setCategory(product.getCategory());
		product2.setDescription(product.getDescription());
		product2.setPrice(product.getPrice());
		return productRepository.save(product2);
	}
	
	
}
