package com.nimap.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

import com.nimap.entities.Category;
import com.nimap.entities.Product;
import com.nimap.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping()
	public ResponseEntity<Page<Product>> getAllProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10")int size){
		Pageable pageable=PageRequest.of(page, size,Sort.by("productId").ascending());
		Page<Product> products=productService.getAllProducts(pageable);
		return ResponseEntity.ok(products);
	}
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product ){
		return ResponseEntity.ok(productService.createProduct(product));
	}
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id){
		Optional<Product> product=productService.getProduct(id);
		return product.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
	}
	
	 @PutMapping("/{id}")
	 public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product productDetails) {
	     Product updatedProduct = productService.updateProduct(id, productDetails);
	     return ResponseEntity.ok(updatedProduct);
	 }
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
	    productService.deleteProduct(id);
	     return ResponseEntity.noContent().build();
	 }
}
