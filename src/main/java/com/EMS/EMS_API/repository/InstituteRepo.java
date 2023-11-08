package com.EMS.EMS_API.repository;

import com.EMS.EMS_API.entity.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituteRepo extends JpaRepository<Institute,Long> {

}
