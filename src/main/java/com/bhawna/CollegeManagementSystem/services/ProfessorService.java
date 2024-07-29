package com.bhawna.CollegeManagementSystem.services;

import com.bhawna.CollegeManagementSystem.entities.ProfessorEntity;
import com.bhawna.CollegeManagementSystem.entities.StudentEntity;
import com.bhawna.CollegeManagementSystem.entities.SubjectEntity;
import com.bhawna.CollegeManagementSystem.repositories.ProfessorRepository;
import com.bhawna.CollegeManagementSystem.repositories.StudentRepository;
import com.bhawna.CollegeManagementSystem.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;

    public ProfessorService(ProfessorRepository professorRepository, SubjectRepository subjectRepository, StudentRepository studentRepository) {
        this.professorRepository = professorRepository;
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }

    public ProfessorEntity getProfessorById(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    public ProfessorEntity createNewProfessor(ProfessorEntity professorEntity) {
        return professorRepository.save(professorEntity);
    }

    public ProfessorEntity assignProfessorToSubject(Long professorId, Long subjectId) {
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(professorId);
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);

        return professorEntity.flatMap(professor ->
                subjectEntity.map(subject->{
                    subject.setProfessor(professor);
                    subjectRepository.save(subject);

                    professor.getSubjects().add(subject);
                    return professor;
                })
        ).orElse(null);
    }

    public ProfessorEntity assignProfessorToStudent(Long professorId, Long studentId) {
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(professorId);
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);


        return professorEntity.flatMap(professor ->
                        studentEntity.map(student->{
                            student.getProfessors().add(professor);

                            professor.getStudents().add(student);
                            professorRepository.save(professor);
                            return professor;
                        })
        ).orElse(null);


    }
}
