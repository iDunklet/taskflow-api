# TaskFlow API

A REST API for task management built with Java, Spring Boot, Spring Data JPA, Hibernate and PostgreSQL.

This project was developed to practice back-end development, RESTful API design, database persistence and CRUD operations.

## Technologies

- **Java 21**
- **Spring Boot 4**
- **Spring Web MVC**
- **Spring Data JPA / Hibernate**
- **PostgreSQL 17**
- **Docker Compose**
- **Maven**

## Features

- Create new tasks
- Retrieve all tasks
- Retrieve a task by ID
- Update existing tasks
- Delete tasks
- Return HTTP 404 when a task does not exist

## API Endpoints

Base URL: `http://localhost:8080/api/tasks`

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/tasks` | Create a new task |
| GET | `/api/tasks` | Retrieve all tasks |
| GET | `/api/tasks/{id}` | Retrieve a task by ID |
| PUT | `/api/tasks/{id}` | Update an existing task |
| DELETE | `/api/tasks/{id}` | Delete a task |

## Task Model

Each task contains the following fields:

| Field | Type | Description |
|---|---|---|
| `id` | Long | Unique identifier |
| `title` | String | Task title |
| `description` | String | Task description |
| `status` | Enum | Current task status |

Available task statuses:

- `PENDING`
- `IN_PROGRESS`
- `COMPLETED`

## Example Request

**POST** `/api/tasks`

```json
{
  "title": "Learn Spring Boot",
  "description": "Build my first REST API",
  "status": "PENDING"
}
```

## Getting Started

### Prerequisites

- Java 21 or later
- Docker and Docker Compose
- Maven or an IDE with Maven support

### 1. Clone the repository

```bash
git clone https://github.com/IDunklet/taskflow-api.git
cd taskflow-api
```

Replace `YOUR_USERNAME` with your GitHub username.

### 2. Start PostgreSQL

```bash
docker compose up -d
```

This starts the PostgreSQL database using the project's `compose.yaml` configuration.

### 3. Configure the environment variable

The application reads the database password from the `DB_PASSWORD` environment variable.

Set it to match the password configured for your local PostgreSQL container.

For example, in PowerShell:

```powershell
$env:DB_PASSWORD="your_local_database_password"
```

### 4. Run the application

Start `TaskflowApiApplication` from IntelliJ IDEA, or use Maven:

```bash
mvn spring-boot:run
```

The API will be available at:

`http://localhost:8080/api/tasks`

## Project Structure

```text
src/main/java/com/taskflow/
├── TaskflowApiApplication.java
└── task/
    ├── controller/
    │   └── TaskController.java
    ├── entity/
    │   ├── Task.java
    │   └── TaskStatus.java
    ├── repository/
    │   └── TaskRepository.java
    └── service/
        └── TaskService.java
```

## Project Status

The initial CRUD functionality has been implemented and manually tested using Postman.

### Planned Improvements

- Data Transfer Objects (DTOs)
- Request validation
- Global exception handling
- Automated unit and integration tests
- Improved API documentation

## Author

Developed as a personal back-end learning and portfolio project.