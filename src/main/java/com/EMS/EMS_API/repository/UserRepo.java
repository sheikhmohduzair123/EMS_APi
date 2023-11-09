package com.EMS.EMS_API.repository;

import com.EMS.EMS_API.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User  findByName(String username);
}
