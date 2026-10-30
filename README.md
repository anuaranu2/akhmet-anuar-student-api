# Akhmet Anuar Student API - Documentation Branch
# Akhmet Anuar Student API

**Student:** Anuar Akhmet  
**Course:** DevOps  
**Project:** Spring Boot Student CRUD API

## Description

This project is a RESTful Student Management API
developed using Spring Boot 4.0.9 and Java 21.

The application supports CRUD operations:

- Create a student
- Retrieve all students
- Retrieve a student by ID
- Update student information
- Delete a student
- Return HTTP 404 when a student does not exist

## Technologies

- Java 21
- Spring Boot 4.0.9
- Gradle 9.8.2
- Spring Data JPA
- PostgreSQL
- H2 Database for testing
- Docker and Docker Compose
- Jenkins CI/CD

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | /api/students | Create student |
| GET | /api/students | Get all students |
| GET | /api/students/{id} | Get student by ID |
| PUT | /api/students/{id} | Update student |
| DELETE | /api/students/{id} | Delete student |

## Automated Tests

StudentCrudTests verifies CRUD operations
using an in-memory H2 database.

Run tests:

```bash
./gradlew clean test
```

## Author

Anuar Akhmet

