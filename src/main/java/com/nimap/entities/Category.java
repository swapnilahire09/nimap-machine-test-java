package com.nimap.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "categories")

public class Category{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	
	@NotNull
	@Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
	@Column(nullable = false,unique = true)
	private String name;
	
	@Size(max = 255, message = "Description should not exceed 255 characters")
	private String description;
	
	@PastOrPresent(message = "Created date cannot be in the future")
	private LocalDateTime createdAt;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnoreProperties("category") 
	private List<Product> products;
	
	@PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + ", description=" + description + ", createdAt="
				+ createdAt + "]";
	}
	public Category(int categoryId, String name, String description, LocalDateTime createdAt) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.createdAt = createdAt;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
