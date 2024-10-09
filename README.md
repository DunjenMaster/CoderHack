# CoderHack Leaderboard API

A RESTful API service developed using Spring Boot and MongoDB for managing the leaderboard of a coding platform. The platform awards users with badges based on their scores in a contest.

## Problem Description

This service manages the leaderboard for a specific contest on a coding platform. Each user has a unique ID, a username, and a score. The leaderboard awards virtual badges to users based on their scores. The service includes functionality to register users, update scores, and manage badges according to the following criteria:

- `1 <= Score < 30` -> Code Ninja
- `30 <= Score < 60` -> Code Champ
- `60 <= Score <= 100` -> Code Master

## Requirements

- The API handles **CRUD operations** for user registration and management.
- Each user has the following fields:
  - **User ID**: Unique Identifier (UUID)
  - **Username**: Name of the user
  - **Score**: User’s score (0 <= Score <= 100)
  - **Badges**: Virtual awards based on score

## Features

- **User registration** with an initial score of 0 and no badges.
- **Score update** which also updates badges according to the score.
- **User retrieval**, sorted by scores in descending order.
- **User deletion**.

## API Endpoints

| Method | Endpoint               | Description                          |
|--------|------------------------|--------------------------------------|
| GET    | `/users`               | Retrieve a list of all registered users, sorted by score |
| GET    | `/users/{userId}`      | Retrieve details of a specific user  |
| POST   | `/users`               | Register a new user                  |
| PUT    | `/users/{userId}`      | Update the score of a specific user  |
| DELETE | `/users/{userId}`      | Deregister a specific user           |

## Project Setup

### Prerequisites

- Java 11+
- Maven 3.9+
- MongoDB (Running locally or in a Docker container)

### How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/DunjenMaster/CoderHack.git
   cd coderhack

2. Build the project: mvn clean install
3. Start MongoDB: a- If running locally, ensure MongoDB is running on localhost:27017
4. If using Docker: docker run -d -p 27017:27017 --name mongo-container mongo
5. Run the application: mvn spring-boot:run
6. MongoDB Config(application.properties): spring.data.mongodb.host=localhost
                           spring.data.mongodb.port=27017
                           spring.data.mongodb.database=coderhack
7. Run the test case: mvn test


