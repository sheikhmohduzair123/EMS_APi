package com.EMS.EMS_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewTask extends JpaRepository<NewTask,Long> {
}
