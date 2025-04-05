# 📘 Nimap Machine Test – Bookstore API

This project is developed as part of the **Nimap Infotech Machine Test** using **Java, Spring Boot, JPA, and Hibernate**. It provides RESTful APIs for performing CRUD operations on **Categories** and **Products**, including the use of **Postman** for testing.

---

## 🧾 Requirements Fulfilled

✅ Developed using **Spring Boot**  
✅ REST APIs using **@RestController**  
✅ Database configured using **RDBMS (PostgreSQL)**  
✅ **Annotation-based configuration**
✅ **JPA & Hibernate** integration  
✅ CRUD operations for **Product** and **Category**  
✅ **One-to-Many** relation: One Category ➝ Many Products  
✅ API tested via **Postman**

---

## 💻 Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA (Hibernate)
- PostgreSQL
- Maven
- Postman (for testing)

---

## 🧩 Project Features

- Add, update, fetch, and delete Categories and Products.
- Products are associated with a Category (many products under one category).
- Auto-generated timestamps (`createdAt`) for entities.
- Server-side validation using **Jakarta Validation** annotations.
- **@PrePersist** used for setting creation date.
- Tested using **Postman** with proper request/response JSON.

---

## 🔗 API Endpoints

### 📁 Category APIs

| Method | Endpoint                      | Description               |
|--------|-------------------------------|---------------------------|
| GET    | `/api/categories?page=0`      | Get paginated categories  |
| POST   | `/api/categories`             | Create a category         |
| GET    | `/api/categories/{id}`        | Get category by ID        |
| PUT    | `/api/categories/{id}`        | Update category by ID     |
| DELETE | `/api/categories/{id}`        | Delete category by ID     |

### 📦 Product APIs

| Method | Endpoint                      | Description                      |
|--------|-------------------------------|----------------------------------|
| GET    | `/api/products?page=0`        | Get paginated products           |
| POST   | `/api/products`               | Create a product (with category) |
| GET    | `/api/products/{id}`          | Get product by ID                |
| PUT    | `/api/products/{id}`          | Update product by ID             |
| DELETE | `/api/products/{id}`          | Delete product by ID             |

---

## 🧬 Entity Relationship

- **One-to-Many** between Category and Products:
  - One Category can have many Products.
  - `@OneToMany` and `@ManyToOne` are used.

```java
// Category.java
@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
private List<Product> products;

// Product.java
@ManyToOne
@JoinColumn(name = "category_id", nullable = false)
private Category category;

🙋‍♂️ Author
Swapnil Ahire
MCA Graduate | Java Developer
📍 Pune, India
📧 Email: ahireswapnil0926@gmail.com
🔗 LinkedIn: https://www.linkedin.com/in/swapnil-ahire09
