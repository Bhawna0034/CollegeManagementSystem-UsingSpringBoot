package com.bhawna.CollegeManagementSystem.controllers;

import com.bhawna.CollegeManagementSystem.entities.ProfessorEntity;
import com.bhawna.CollegeManagementSystem.services.ProfessorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "professors")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping(path = "/{professorId}")
    public ProfessorEntity getProfessorById(@PathVariable(name = "professorId") Long id){
        return professorService.getProfessorById(id);
    }

    @PostMapping
    public ProfessorEntity createNewProfessor(@RequestBody ProfessorEntity professorEntity){
        return professorService.createNewProfessor(professorEntity);
    }

    @PutMapping(path = "/{professorId}/subject/{subjectId}")
    public ProfessorEntity assignProfessorToSubject(@PathVariable Long professorId,
                                                    @PathVariable Long subjectId){
        return professorService.assignProfessorToSubject(professorId, subjectId);
    }

    @PutMapping(path = "/{professorId}/student/{studentId}")
    public ProfessorEntity assignProfessorToStudent(@PathVariable Long professorId,
                                                    @PathVariable Long studentId){
        return professorService.assignProfessorToStudent(professorId, studentId);
    }
}
