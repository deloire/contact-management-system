## Description

User Contact Management API is a RESTful web service that allows users to manage their contacts efficiently. This API enables user registration, retrieval of user information along with the count of their contacts, and offers functionality to add, update, and delete contacts. It is built using Spring Boot and follows best practices for RESTful API design.

## Features

- **User Registration**: Create new users with unique usernames and passwords.
- **Contact Management**: Add, update, retrieve, and delete contacts associated with a user.
- **Count Contacts**: Retrieve the total number of contacts for a specific user.
- **Error Handling**: Comprehensive error handling with meaningful messages.

## Technologies Used

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**

### Installation

1. Clone the repository
2. Navigate to your project directory and put pom.xml and other files there
3. Build the project using Maven
4. Run the application
5. The application will start on `http://localhost:8080`.

### API Endpoints

| Method | Endpoint                          | Description                                |
|--------|-----------------------------------|--------------------------------------------|
| POST   | `/users`                          | Register a new user                        |
| GET    | `/users/{username}`               | Get user details along with contact count  |
| POST   | `/users/{username}/contacts`      | Add a new contact for the user             |
| GET    | `/users/{username}/contacts`      | Get all contacts for the user              |
| PUT    | `/users/{username}/contacts/{id}` | Update an existing contact                 |
| DELETE | `/users/{username}/contacts/{id}` | Delete a contact by ID                     |
