# Learning Management System (LMS) Microservices with Spring Boot

# Development Status

## Still in early development, no passing version available yet

---

## Overview

This is a **LMS Microservices Back-End** using **Java** and **Spring Boot** following
**Clean Architecture** and **SOLID Principles**.

It serves as a demonstration of the implementation of microservices following some of the
best development practices.

---

## Development Status

### Still in development, no passing version available yet

## Quick Info

![Java](https://img.shields.io/badge/java-21-brightgreen)
![SpringBoot](https://img.shields.io/badge/spring--boot-3.5.6-brightgreen)
![Maven](https://img.shields.io/badge/Maven-3.9.11-blue)
![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![License](https://img.shields.io/badge/license-MIT-brightgreen)

![Last Commit](https://img.shields.io/github/last-commit/arivan-amin/LMS-Microservices)
![Repo Size](https://img.shields.io/github/repo-size/arivan-amin/LMS-Microservices)
![Contributors](https://img.shields.io/github/contributors/arivan-amin/LMS-Microservices)
![Platform](https://img.shields.io/badge/platform-Linux%20%7C%20Windows%20%7C%20MacOS-informational)

## Notable Features

### Automatic Audit Logs Recording

Use Spring **AOP** to create Audit Events automatically whenever any API in any of the services are
called and save it to persistence, allowing the controllers to be clutter-free.

### Clean Restful API in all services

The API follows the modern best practices in RESTful services recommendations,
like using **ResponseEntity** and returning **ProblemDetail**.

### CQRS

Command and Query Separation Principle to implement Business logic.

### Rate Limiting

Implemented in **API Gateway** using **Redis Rate Limiter**.

### Outbox Pattern

Implements Outbox Pattern for sending audit events to guarantee 100% message delivery.

### ArchUnit

Validate architectural boundaries and verify adherence to best coding standards.

### PMD and Pitest

Use PMD to verify the coding style and Pitest for mutation testing.

### RestControllerAdvice

Handle specific exceptions and return a unified and standard error response instead of an exception
stack trace using Spring **ProblemDetail**.
Example of API response for every error.

```
{
    "type": "https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/RuntimeException.html",
    "title": "Requested Student Not Found",
    "status": 404,
    "detail": "Student by the requested id not found",
    "instance": "/students/protected/v1/accounts/33bff7c7-77ee-4c51-9ee0-c870b437f82e",
    "category": "Resource Not Found",
    "timestamp": "2025-04-22T18:45:43.927431130Z"
}
```

### OpenAPI and Swagger Docs

Provides detailed documentation for all endpoints.

### Entity and DTO separation

Decouples core business logic from presentation using request and response POJO.

### Core Entity and JPA separation

Core entities have no association with JPA and are never annotated with @Entity.

## Sample audit log from Audit-Service captured from API calls in Student-Service

```
        // Create Student Endpoint
        {
            "id": "6797e0215829937787277607",
            "serviceName": "student-service",
            "location": "/students/protected/v1/accounts",
            "action": "Create",
            "data": "CreateStudentRequest(firstName=Hayden, lastName=Ondricka, email=Helen21@gmail.com, dateOfBirth=977659882000, gender=MALE, address=Bernhard Cape)",
            "creationDate": "2025-01-27T14:36:01.528",
            "duration": "50ms",
            "response": "CreateStudentResponse(id=9622e5ef-5ab7-4faf-89db-7dd970ea8ef0)"
        }

        // Delete Student Endpoint
        {
            "id": "6797e0115829937787277605",
            "serviceName": "student-service",
            "location": "/students/protected/v1/accounts/{id}",
            "action": "Delete",
            "data": "e8cd23d1-4bad-44bb-9b58-a3ca89dbf793",
            "creationDate": "2025-01-27T14:35:45.631",
            "duration": "25ms",
            "response": "Void"
        },
        
        // Read Student by ID Endpoint
        {
            "id": "6797e0145829937787277606",
            "serviceName": "student-service",
            "location": "/students/protected/v1/accounts/{id}",
            "action": "Read",
            "data": "e8cd23d1-4bad-44bb-9b58-a3ca89dbf793",
            "creationDate": "2025-01-27T14:35:48.66",
            "duration": "14ms",
            "response": "Error: Student by the requested id not found"
        }
```

## Architecture concepts and technical features demonstrated and implemented

- **Microservices Architecture**.
- **Clean Architecture & Clean Code**
- **Command-Query Responsibility Separation (CQRS)**
- **SOLID Principles**
- **Mutation Testing**
- **Spring Dependency Injection**
- **Aspect-Oriented Programming (AOP)**
- **Rate Limiting API**
- **Automatic Audit Logs recording**: Uses Spring AOP to store audit logs automatically.
- **Event-Driven Communication**: Using Kafka.
- **Robust Monitoring**: Real-time monitoring with Grafana, Loki, and Tempo.
- **Centralized Logging & Distributed Tracing**: Using Loki and Tempo.
- **Database Migrations**: Using Liquibase.
- **Dockerized Deployment**: Using Docker and Docker Compose.

---

### Currently, the following services are implemented; other services will be added:

- Discovery Server
- API Gateway
- Student Service
- Audit Service

---

## Technologies used and their responsibility

- **Java 21**
- **Spring Boot**
- **Spring Cloud**
- **Eureka**: Dynamic service registry.
- **MySQL**: Services data storage.
- **Kafka**: Event streaming for microservices.
- **Keycloak**: Authentication and SSO provider.
- **Docker**
- **Grafana, Loki, Tempo**: Observability stack for metrics, logging, and tracing.
- **JUnit & Mockito**: Unit testing and Mocking.
- **ArchUnit**: Architecture boundaries testing and coding standards validation.
- **PMD**: Validate coding standards and best practices.
- **Pitest**: Mutation testing.
- **Swagger/OpenAPI**: API documentation.
- **Liquibase**: Database Migrations.
- **Lombok**: Cleaner code with reduced boilerplate.

---

## Grafana Monitoring Sample

![image](https://raw.githubusercontent.com/arivan-amin/Spring-Clean-Microservices/master/Docs/Grafana/Grafana-Dashboard-1.png)

## Installation Guide

### Prerequisites

- **Java 21**
- **Maven**
- **Docker** & **Docker Compose**

---

### Steps to Get Started

1. **Clone the Repository:**
   ```
   git clone https://github.com/arivan-amin/Spring-Clean-Microservices.git
   cd Spring-Clean-Microservices
   ```

2. **Build and deploy the services to Docker using JIB:**
   ```
   mvn clean install
   ```

3. **Set Environment Variables (Linux/MacOS):**
   ```
   export EUREKA_USER=admin
   export EUREKA_PASSWORD=admin
   ```
   ```
   *(For Windows, use `set` command)*
   ```

4. **Start the required backbone apps with Docker Compose:**
   ```
   docker compose up -d
   ```
5. **Start the services(Student, Audit, ...) manually or uncomment the section in docker compose
   file
   to run everything with Docker Compose:**
   ```
   docker compose up -d
   ```

# Access the Services

## API Gateway

[http://localhost:8080](http://localhost:8080)

## Eureka Dashboard

#### Username: admin

#### Password: admin

[http://localhost:8080/eureka/web](http://localhost:8080/eureka/web)

## API Documentation

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Grafana Dashboard

#### Import pre-built dashboard JSON configuration from the `docker/grafana/` folder

[http://localhost:3000/dashboards](http://localhost:3000/dashboards)

---

## Testing

- **Run Unit and Integration Tests:**
   ```bash
   mvn test
   ```

---

## Microservices Overview

- **Discovery Server**: Dynamic service discovery and registry.
- **API Gateway**: Centralized entry point for routing and security.
- **Core Module**: Shared utilities and functionality.
- **Outbox Storage Module**: Contains classes related to outbox messages storage, shared with
  all the modules.
- **Student Service**: Manages student data.
- **Audit Service**: Stores Audit Events, ensures compliance and data integrity.

---

## Contributing

We welcome contributions! Fork the repository, create a new branch, and submit a pull request.

---

## License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for more
details.

---

## Contact

For questions or inquiries:

- **Name:** Arivan Amin
- **Email:** [arivanamin@gmail.com](mailto:arivanamin@gmail.com)
