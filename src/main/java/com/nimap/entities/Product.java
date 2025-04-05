package com.nimap.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;

	@NotBlank(message = "Title cannot be blank")
	@Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
	@Column(nullable = false)
	private String title;
	
	@NotBlank(message = "Author cannot be blank")
	@Size(min = 3, max = 50, message = "Author name must be between 3 and 50 characters")
	private String author;
	
	@ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
	@JsonIgnoreProperties("products") 
	private Category category;
	
	 @Size(max = 500, message = "Description should not exceed 500 characters")
	private String description;
	@Positive(message = "Price must be greater than zero")
	private double price;
	
	@PastOrPresent(message = "Created date cannot be in the future")
	private LocalDateTime createdAt;

	@PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Product(int productId,
			@NotBlank(message = "Title cannot be blank") @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters") String title,
			@NotBlank(message = "Author cannot be blank") @Size(min = 3, max = 50, message = "Author name must be between 3 and 50 characters") String author,
			@NotBlank(message = "Category is required") Category category,
			@Size(max = 500, message = "Description should not exceed 500 characters") String description,
			@Positive(message = "Price must be greater than zero") double price,
			@PastOrPresent(message = "Created date cannot be in the future") LocalDateTime createdAt) {
		super();
		this.productId = productId;
		this.title = title;
		this.author = author;
		this.category = category;
		this.description = description;
		this.price = price;
		this.createdAt = createdAt;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", title=" + title + ", author=" + author + ", category=" + category
				+ ", description=" + description + ", price=" + price + ", createdAt=" + createdAt + "]";
	}

	
}
