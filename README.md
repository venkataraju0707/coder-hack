Coder-Hack Leaderboard API 🏆

A Spring Boot RESTful API for managing the leaderboard of a coding platform contest.
The service supports CRUD operations for users, maintains scores, assigns badges dynamically, and persists data using MongoDB.

📌 Problem Statement

Develop a RESTful API service using Spring Boot to manage the Leaderboard for a Coding Platform, while using MongoDB to persist the data.

The platform hosts a single contest with one leaderboard. Users are rewarded with badges based on their score.

✨ Features

👤 User Registration with UserID & Username

📝 CRUD Operations on registered users

🏆 Leaderboard sorted by score in ascending order

🎖 Automatic Badge Assignment based on score:

1 <= Score < 30 → Code Ninja

30 <= Score < 60 → Code Champ

60 <= Score <= 100 → Code Master

✅ Validation & Error Handling with proper HTTP codes

⚡ Optimized Sorting (O(n log n))

🔍 JUnit Test Cases to verify API behavior

🛠️ Tech Stack

Backend: Spring Boot 3+

Database: MongoDB

Build Tool: Maven / Gradle

Testing: JUnit 5, Mockito

API Testing: Postman

📂 Project Structure
coder-hack/
│── src/main/java/com/coderhack/
│   ├── controller/      # REST Controllers
│   ├── service/         # Business Logic
│   ├── repository/      # MongoDB Repositories
│   ├── model/           # Entities (User, Badge Enum)
│   └── exception/       # Custom Exceptions & Handlers
│
│── src/test/java/com/coderhack/   # JUnit Test Cases
│── pom.xml              # Maven Dependencies
│── README.md            # Documentation

📌 API Endpoints
Base URL
http://localhost:8081/coderhack/api/v1

1️⃣ Create a User

POST /users
Registers a new user.

Request Body:

{
  "userId": "U101",
  "username": "john_doe"
}


Response:

{
  "userId": "U101",
  "username": "john_doe",
  "score": 0,
  "badges": []
}
2️⃣ Get All Users (Leaderboard)

GET /users
Returns all registered users sorted by score.

Response:

[
  {
    "userId": "U101",
    "username": "john_doe",
    "score": 50,
    "badges": ["Code Champ"]
  }
]

3️⃣ Get User by ID

GET /users/{userId}

Response:

{
  "userId": "U101",
  "username": "john_doe",
  "score": 50,
  "badges": ["Code Champ"]
}

4️⃣ Update User Score

PUT /users/{userId}

Request Body:

{
  "score": 65
}


Response:

{
  "userId": "U101",
  "username": "john_doe",
  "score": 65,
  "badges": ["Code Master"]
}

5️⃣ Delete User

DELETE /users/{userId}

Response:

{
  "message": "User U101 deleted successfully."
}
Validations & Rules

UserID must be unique

Username must not be empty

Score must be between 0 and 100

Badges update automatically based on score

Users can have max 3 unique badges

🧪 Testing

Run unit tests:

mvn test


Example test cases:

✅ Create user with valid fields

❌ Fail if score < 0 or score > 100

✅ Update score updates badges automatically

❌ Get non-existent user returns 404 NOT FOUND
