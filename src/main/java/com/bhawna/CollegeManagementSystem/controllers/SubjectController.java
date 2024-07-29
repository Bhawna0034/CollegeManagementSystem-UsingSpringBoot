package com.bhawna.CollegeManagementSystem.controllers;

import com.bhawna.CollegeManagementSystem.entities.SubjectEntity;
import com.bhawna.CollegeManagementSystem.services.SubjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping(path = "/{subjectId}")
    public SubjectEntity getSubjectById(@PathVariable(name = "subjectId") Long id){
        return subjectService.getSubjectById(id);
    }

    @PostMapping
    public SubjectEntity createNewSubject(@RequestBody SubjectEntity subjectEntity){
        return subjectService.createNewSubject(subjectEntity);
    }
}

