package com.bhawna.CollegeManagementSystem.controllers;

import com.bhawna.CollegeManagementSystem.entities.StudentEntity;
import com.bhawna.CollegeManagementSystem.services.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/{studentId}")
    public StudentEntity getStudentById(@PathVariable(name = "studentId") Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    public StudentEntity createNewStudent(@RequestBody StudentEntity studentEntity){
        return studentService.createNewStudent(studentEntity);
    }

    @PutMapping(path = "/{studentId}/subject/{subjectId}")
    public StudentEntity assignStudentToSubject(@PathVariable Long studentId,
                                                 @PathVariable Long subjectId){
        return studentService.assignStudentToSubject(studentId, subjectId);
    }
}
