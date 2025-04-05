package com.nimap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nimap.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
