# College Management System
## Overview
The College Management System is a Spring Boot application that helps manage a college's operations, including student enrollment, subject management, professor assignments, and admission records. It uses Spring Data JPA to handle database interactions and entity relationships.


## Features
 - Student Management: Add, update, and view student information.<br>
 - Subject Management: Create and manage subjects.<br>
 - Professor Management: Assign professors to subjects, professors to students and manage their details.<br>
 - Admission Records: Manage student admissions and their records.<br>


 ## Technologies Used
  - Spring Boot <br>
  - Spring Data JPA <br>
  - Hibernate <br>
  - MySQL <br>
  - Maven <br>
  

  ## Entity Relationships
  - OneToOne: Between Student and AdmissionRecord. <br>
  - OneToMany: Between Professor and Subject. <br>
  - ManyToOne: Between Subject and Professor. <br>
  - ManyToMany: Between Student and Subject. <br>
  - ManyToMany: Between Student and Professor. <br>
  

  ## APIs
  ### Student API:
  
   -   GET /students/{studentId}: Get student by Id. <br>
   -   POST /students: Add a new student. <br>
   -   PUT /students/{studentId}/subject/{subjectId}: Assign student to subject. <br>

     
  ###  Subject API: 
  
  - GET /subjects/{subjectId}: Get subject by Id. <br>
  - POST /subjects: Add a new subject.<br>
     
  ### Professor API:

 - GET /professors/professorId: Get professor by Id.<br>
 - POST /professors: Add a new professor.
 - PUT /professors/{professorId}/subject/{subjectId}: Assign professor to subject. <br>
 - PUT /professors/{professorId}/student/{studentId}: Assign professor to student. <br>
 
 ### Admission Records API:

 - GET /admissionRecords{admissionRecordsId}/: Get admission records by Id.
 - POST /admissionRecords: Add a new admission record.
 - PUT /admissionRecords/{admissionRecordId}/student/{studentId}: Update admisson records of student.


 ##  Getting Started
 
 ### Prerequisites
 
 - JDK 11 or higher <br>
 - Maven <br>
 - MySQL database <br>


 ## Setup

 ### 1. Clone the repository:
    git clone https://github.com/Bhawna0034/college-management-system.git
    cd college-management-system

 ### 2. Configure the database
     Create a MySQL database named college_management. 
     Update the application.properties file in src/main/resources with your database credentials: 
     
         spring.datasource.url=jdbc:mysql://localhost:3306/college_management
         spring.datasource.username=yourusername
         spring.datasource.password=yourpassword
         spring.jpa.hibernate.ddl-auto=create

 ### 3. Access the application
   Open your browser and go to http://localhost:8080/swagger-ui/index.html

# License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

# Contact
Bhawna - bhawnaasharma0034@gmail.com <br>
Project Link: https://github.com/Bhawna0034/CollegeManagementSystem-UsingSpringBoot.git


   


