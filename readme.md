#Student Management System API Docs 

Inga större problem med uppgiften. Dock var jag lite osäker på hur JSON responsen skulle se ut om det skulle visa mer en ett enkelt textmeddelande. 
Men jag valde att köra med en Object instans.

För att testa alla endpoints för Subject så räcker det med att följa den nedre tabellen från top till bott. 

##Student Route
| Method   | URL                                                                                         | Description                                |
|----------|---------------------------------------------------------------------------------------------|--------------------------------------------|
| `GET`    | `http://localhost:8080/student-management-system/api/v1/students/`                          | Retrieve all students.                     |
| `GET`    | `http://localhost:8080/student-management-system/api/v1/students/{id}`                      | Retrieve student by their id.              |
| `GET`    | `http://localhost:8080/student-management-system/api/v1/students/query?lastName={lastName}` | Retrieve student by their lastName.        |
| `POST`   | `http://localhost:8080/student-management-system/api/v1/students/`                          | Create student                             |
| `DELETE` | `http://localhost:8080/student-management-system/api/v1/students/`                          | Remove student                             |
| `PUT`    | `http://localhost:8080/student-management-system/api/v1/students/`                          | Update student                             |

##Subject Route
| Method   | URL                                                                                                | Description                   |
|----------|----------------------------------------------------------------------------------------------------|-------------------------------|
| `GET`    | `http://localhost:8080/student-management-system/api/v1/subjects/`                                 | Retrieve all subjects.        |
| `GET`    | `http://localhost:8080/student-management-system/api/v1/subjects/{id}`                             | Retrieve subject by their id. |
| `POST`   | `http://localhost:8080/student-management-system/api/v1/subjects/`                                 | Create subject                |
| `DELETE` | `http://localhost:8080/student-management-system/api/v1/subjects/{id}`                             | Remove subject                |
| `POST`   | `http://localhost:8080/student-management-system/api/v1/subjects/{subjectId}/students/{studentId}` | Add student to subject        |
| `DELETE` | `http://localhost:8080/student-management-system/api/v1/subjects/{subjectId}/teacher/{studentId}`  | Remove student from subject   |
| `PUT`    | `http://localhost:8080/student-management-system/api/v1/subjects/{subjectId}/teacher/{teacherId}`  | Change teacher for subject    |

##Teacher Route
| Method   | URL                                                                                         | Description                   |
|----------|---------------------------------------------------------------------------------------------|-------------------------------|
| `GET`    | `http://localhost:8080/student-management-system/api/v1/teachers/`                          | Retrieve all teachers.        |
| `GET`    | `http://localhost:8080/student-management-system/api/v1/teachers/{id}`                      | Retrieve teacher by their id. |
| `POST`   | `http://localhost:8080/student-management-system/api/v1/teachers/`                          | Create teacher                |
| `DELETE` | `http://localhost:8080/student-management-system/api/v1/teachers/`                          | Remove teacher                |
| `PUT`    | `http://localhost:8080/student-management-system/api/v1/teachers/`                          | Update teacher                |
    