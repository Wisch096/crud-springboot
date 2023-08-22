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
  
### 2. List Persons

- **Method:** `GET`
- **Endpoint:** `/persons`

### 3. Add Task

- **Method:** `POST`
- **Endpoint:** `/tasks`
- **Payload:** JSON with `title`, `description`, `deadline`, `department`, and `allocatedPersonId` fields
- **Example Payload:**
  ```json
  {
    "title": "Task 1",
    "description": "Description for Task 1",
    "deadline": "2023-09-01",
    "department": "Department A",
    "allocatedPersonId": 1
  }

  ### 4. List Tasks

- **Method:** `GET`
- **Endpoint:** `/tasks`

### 5. Allocate Task to Person

- **Method:** `PUT`
- **Endpoint:** `/tasks/{taskId}/allocate/{personId}`
- **Example Endpoint:** `/tasks/1/allocate/2`

### 6. Finish Task

- **Method:** `PUT`
- **Endpoint:** `/tasks/{taskId}/finish`
- **Example Endpoint:** `/tasks/1/finish`

### 7. List Oldest Unallocated Tasks

- **Method:** `GET`
- **Endpoint:** `/tasks/pending?limit=3`
- **Example Endpoint:** `/tasks/pending?limit=3`

### 8. List Department Summaries

- **Method:** `GET`
- **Endpoint:** `/departments`

## Running the Project

1. Clone the repository to your local machine.
2. Open the project in your IDE (e.g., IntelliJ IDEA or Eclipse).
3. Run the `MatheusApplication` class to start the Spring Boot application.
4. Use tools like Postman or cURL to test the CRUD functionalities.
