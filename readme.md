#Student Management System API Docs 

| Method   | URL                                                                                         | Description                                |
|----------|---------------------------------------------------------------------------------------------|--------------------------------------------|
| `GET`    | `http://localhost:8080/student-management-system/api/v1/students/`                          | Retrieve all students.                     |
| `GET`    | `http://localhost:8080/student-management-system/api/v1/students/{id}`                      | Retrieve student by their id.              |
| `GET`    | `http://localhost:8080/student-management-system/api/v1/students/query?lastName={lastName}` | Retrieve student by their lastName.        |
| `POST`   | `http://localhost:8080/student-management-system/api/v1/students/`                          | Create student                             |
| `DELETE` | `http://localhost:8080/student-management-system/api/v1/students/`                          | Remove student                             |
| `PUT`    | `http://localhost:8080/student-management-system/api/v1/students/`                          | Update student                             |
    