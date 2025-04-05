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
import com.nimap.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	private CategoryService categoryService;
	
	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping
	public ResponseEntity<Page<Category>> getAllCategory(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
		Pageable pageable=PageRequest.of(page, size,Sort.by("categoryId").ascending());
		Page<Category> categories=categoryService.getAllCategories(pageable);
		return ResponseEntity.ok(categories);
	}
	@PostMapping
	public ResponseEntity<Category> createCategory(@RequestBody Category category ){
		return ResponseEntity.ok(categoryService.createCategory(category));
	}
	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable int id){
		Optional<Category> category=categoryService.getCategory(id);
		return category.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
	}
	
	 @PutMapping("/{id}")
	 public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category categoryDetails) {
	     Category updatedCategory = categoryService.updateCategory(id, categoryDetails);
	     return ResponseEntity.ok(updatedCategory);
	 }
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
	     categoryService.deleteCategory(id);
	     return ResponseEntity.noContent().build();
	 }
}
