package com.EMS.EMS_API.service;

import com.EMS.EMS_API.entity.AcademicTerm;
import com.EMS.EMS_API.entity.Institute;
import com.EMS.EMS_API.repository.AcademicTermRepo;
import com.EMS.EMS_API.repository.InstituteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstituteService {
    @Autowired
    private  InstituteRepo instituteRepo;
    @Autowired
    private AcademicTermRepo academicTermRepo;

    public List<Institute> getAllInstitute() {
        return instituteRepo.findAll();
    }

    public Institute getInstituteById(Long id) {
        return instituteRepo.findById(id).orElse(null);
    }

    public Institute createInstitute(Institute institute) {
        return instituteRepo.save(institute);
    }

    public Institute updateInstitute(Long id, Institute updatedInstitute) {
        Institute existingInstitute = instituteRepo.findById(id).orElse(null);
        if (existingInstitute != null) {

            existingInstitute.setName(updatedInstitute.getName());

            return instituteRepo.save(existingInstitute);
        }
        return null;
    }

    public void deleteInstitute(Long id) {
        instituteRepo.deleteById(id);
    }


    public List<AcademicTerm> getAllAcademicTerm() {
       List<AcademicTerm> terms=academicTermRepo.findAll();
       return terms;
    }
}

