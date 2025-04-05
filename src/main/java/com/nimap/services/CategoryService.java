package com.nimap.services;

import java.util.Optional;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.entities.Category;


public interface CategoryService {
	Optional<Category> getCategory(int id);
	
	void deleteCategory(int id);

	Category updateCategory(int id, Category category);

	Category createCategory(Category category);

	Page<Category> getAllCategories(Pageable pageable);
}
