package com.EMS.EMS_API.repository;

import com.EMS.EMS_API.entity.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarksRepo extends JpaRepository<Marks,Long> {
    Marks findByTaskId(Long taskId);
}
