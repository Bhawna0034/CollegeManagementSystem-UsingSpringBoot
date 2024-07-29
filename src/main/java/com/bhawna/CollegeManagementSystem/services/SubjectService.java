package com.bhawna.CollegeManagementSystem.services;

import com.bhawna.CollegeManagementSystem.entities.SubjectEntity;
import com.bhawna.CollegeManagementSystem.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public SubjectEntity getSubjectById(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }

    public SubjectEntity createNewSubject(SubjectEntity subjectEntity) {
        return subjectRepository.save(subjectEntity);
    }
}
