# CRUD Application README

This is a sample project to demonstrate a simple CRUD (Create, Read, Update, Delete) application using Spring Boot, Spring Data JPA, and H2 in-memory database.

## Project Setup

Make sure you have your Java and Spring Boot development environment configured. If not, you can follow the instructions in the official Spring Boot documentation to set up your environment: https://spring.io/guides/gs/spring-boot/

## Database Setup

The project uses an H2 in-memory database to simplify configuration. The `src/main/resources/application.properties` file contains the database configurations.

## CRUD Functionality

The project includes the following CRUD functionalities:

### 1. Add Person

- Method: `POST`
- Endpoint: `/persons`
- Payload: JSON with `name` and `department` fields
- Example Payload:
  ```json
  {
    "name": "Alice",
    "department": "Department A"
  }
