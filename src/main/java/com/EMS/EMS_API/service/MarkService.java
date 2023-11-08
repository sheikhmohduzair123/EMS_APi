package com.EMS.EMS_API.service;

import com.EMS.EMS_API.entity.Marks;
import com.EMS.EMS_API.repository.MarksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {

    private final MarksRepo markRepo;

    @Autowired
    public MarkService(MarksRepo markRepo) {
        this.markRepo = markRepo;
    }

    public List<Marks> getAllNewMarks() {
        return markRepo.findAll();
    }

    public Marks createNewMark(Marks newMark) {
        return markRepo.save(newMark);
    }

    public Marks getNewMarkById(Long id) {
        return markRepo.findById(id).orElse(null);
    }

    public Marks getNewMarkByTaskId(Long taskId) {

        return markRepo.findByTaskId(taskId);
    }

    public Marks updateNewMark(Long id, Marks updatedNewMark) {

        Marks existingMark = markRepo.findById(id).orElse(null);
        if (existingMark != null) {

            existingMark.setMarks(updatedNewMark.getMarks());
            existingMark.setMarks1(updatedNewMark.getMarks1());
            existingMark.setMarks2(updatedNewMark.getMarks2());
            existingMark.setIsAbsent(updatedNewMark.getIsAbsent());
            existingMark.setIsAbsent1(updatedNewMark.getIsAbsent1());
            existingMark.setIsAbsent2(updatedNewMark.getIsAbsent2());
            existingMark.setRollNumber(updatedNewMark.getRollNumber());

            return markRepo.save(existingMark);
        }
        return null;
    }

    public void deleteNewMark(Long id) {

        markRepo.deleteById(id);
    }
}

