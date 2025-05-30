
# 📝 Task Manager

A full-stack task management application that allows users to create, view, update, and delete tasks efficiently.

## 🚀 Features

- Create, edit, delete, and mark tasks as completed
- RESTful API built with Spring Boot
- Responsive user interface using React.js
- Real-time updates via WebSocket
- Data persistence using MySQL
- Environment-based configuration (secure & flexible)

## 🛠️ Technologies Used

### Backend
- Java 17
- Spring Boot 3.4.1
- Spring Data JPA
- MySQL
- MapStruct
- Maven

### Frontend
- React.js
- fetch API

### Tools & Utilities
- dotenv for environment variable management
- Lombok (annotations for cleaner code)
- Spring DevTools (live reload during development)

## 📦 Getting Started

### Prerequisites

- Java 17
- Node.js + npm
- MySQL
- Maven

---

### 🔧 Backend Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/noyaco/TaskManager.git
   cd TaskManager

Create a .env file inside the server/ folder:

DB_HOST=localhost
DB_PORT=3306
DB_NAME=taskmanager
DB_USERNAME=your_username
DB_PASSWORD=your_password


Run the backend:

cd server
mvn spring-boot:run
🌐 Frontend Setup
Go to the client folder:


cd client
Install dependencies:

npm install
Run the React app:


npm start
The app will open at http://localhost:3000

📁 Project Structure

TaskManager/
├── client/          # React frontend
│   └── src/
│       ├── Task/
│       └── TaskList/
│
└── server/
    ├── config/         # Spring Boot backend
    ├── controller/
    ├── dto/
    ├── entity/
    ├── mapper/
    ├── repository/
    ├── service/
    └── application.properties
📌 API Overview
Method	Endpoint	Description
GET	/tasks	Get all tasks
POST	/tasks	Create new task
PUT	/tasks/{id}	Update existing
DELETE	/tasks/{id}	Delete task

👩‍💻 About the Developer
Built with ❤️ by Noya Cohen
GitHub | [![LinkedIn](https://img.shields.io/badge/LinkedIn-Profile-blue?logo=linkedin&style=for-the-badge)](https://www.linkedin.com/in/noyacohen)