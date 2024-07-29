package com.bhawna.CollegeManagementSystem.controllers;

import com.bhawna.CollegeManagementSystem.entities.AdmissionRecordEntity;
import com.bhawna.CollegeManagementSystem.services.AdmissionRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "admissionRecords")
public class AdmissionRecordController {

    private final AdmissionRecordService admissionRecordService;

    public AdmissionRecordController(AdmissionRecordService admissionRecordService) {
        this.admissionRecordService = admissionRecordService;
    }

    @GetMapping(path = "/{admissionRecordId}")
    public Optional<AdmissionRecordEntity> getAdmissionRecordsById(@PathVariable(name = "admissionRecordId") Long id){
        return admissionRecordService.getAdmissionRecords(id);
    }

    @PostMapping
    public AdmissionRecordEntity createNewAdmissionRecord(@RequestBody AdmissionRecordEntity admissionRecordEntity){
        return admissionRecordService.createNewAdmissionRecord(admissionRecordEntity);
    }

    @PutMapping(path = "/{admissionRecordId}/student/{studentId}")
    public AdmissionRecordEntity admissionRecordOfStudent(@PathVariable Long admissionRecordId,
                                                          @PathVariable Long studentId){
        return admissionRecordService.admissionRecordOfStudent(admissionRecordId, studentId);
    }



}
