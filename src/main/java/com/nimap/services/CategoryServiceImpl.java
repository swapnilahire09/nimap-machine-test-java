package com.nimap.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.entities.Category;
import com.nimap.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	private CategoryRepository categoryRepository;
	
	@Autowired
	public void setCategoryRepository(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Optional<Category> getCategory(int id) {
		
		return categoryRepository.findById(id);
	}

	

	@Override
	public Category createCategory(Category category) {
		
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(int id) {
		categoryRepository.deleteById(id);
		
	}

	@Override
	public Category updateCategory(int id,Category category) {
		Category category2=categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found") );
		category2.setName(category.getName());
		category2.setDescription(category.getDescription());
		return categoryRepository.save(category2);
	}

	@Override
	public Page<Category> getAllCategories(Pageable pageable) {
		
		return categoryRepository.findAll(pageable);
	}

}
