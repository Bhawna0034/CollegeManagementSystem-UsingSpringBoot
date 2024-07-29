package com.bhawna.CollegeManagementSystem.services;

import com.bhawna.CollegeManagementSystem.entities.AdmissionRecordEntity;
import com.bhawna.CollegeManagementSystem.entities.StudentEntity;
import com.bhawna.CollegeManagementSystem.repositories.AdmissionRecordRepository;
import com.bhawna.CollegeManagementSystem.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdmissionRecordService {

    private final AdmissionRecordRepository admissionRecordRepository;
    private final StudentRepository studentRepository;

    public AdmissionRecordService(AdmissionRecordRepository admissionRecordRepository, StudentRepository studentRepository) {
        this.admissionRecordRepository = admissionRecordRepository;
        this.studentRepository=studentRepository;
    }

    public Optional<AdmissionRecordEntity> getAdmissionRecords(Long id) {
        return admissionRecordRepository.findById(id);
    }

    public AdmissionRecordEntity createNewAdmissionRecord(AdmissionRecordEntity admissionRecordEntity) {
        return admissionRecordRepository.save(admissionRecordEntity);
    }

    public AdmissionRecordEntity admissionRecordOfStudent(Long admissionRecordId, Long studentId) {
        Optional<AdmissionRecordEntity> admissionRecordEntity = admissionRecordRepository.findById(admissionRecordId);
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);

        return admissionRecordEntity.flatMap(admissionRecord ->
                studentEntity.map(student -> {

                    admissionRecord.setStudents(student);
                    return admissionRecordRepository.save(admissionRecord);
                })).orElse(null);
    }


}
