package com.EMS.EMS_API.repository;

import com.EMS.EMS_API.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task,Long> {
    List<Task> findByAcademicTermAndInstituteIdAndUserId(String academicTerm, Long instituteId, Long userId);
}
