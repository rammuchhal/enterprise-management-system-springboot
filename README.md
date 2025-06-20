# Enterprise Management System – Spring Boot

A Spring Boot-based RESTful API that manages Employees, Departments, and future Project assignments within an enterprise. The application is structured using the Spring MVC architecture, following a layered pattern with Controllers, Services, Repositories, and DTOs to ensure modularity, maintainability, and testability.

## 🚀 Features

- Follows **Spring MVC architecture** with Controller, Service, and Repository layers
- CRUD operations for Employee and Department entities
- Spring Data JPA integration with MySQL database
- DTO pattern with ModelMapper for clean data transfer
- Custom validation annotations (e.g., prime number validation)
- Global exception handling with structured error responses
- Postman-tested REST endpoints

## 🔧 Tech Stack

- Java 24
- Spring Boot
- Spring MVC
- Spring Data JPA
- MySQL
- Maven
- Postman
- IntelliJ IDEA

## 📌 Upcoming Enhancements

- Mapping between Department and Employees (One-to-Many)
- Introduction of Project entity with Employee–Project (Many-to-Many) relationships
- Swagger/OpenAPI documentation for API testing
- Dockerization for easy deployment

## 🛠️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/enterprise-management-system-springboot.git
   cd enterprise-management-system-springboot
