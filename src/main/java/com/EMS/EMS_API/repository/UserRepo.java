package com.EMS.EMS_API.repository;

import com.EMS.EMS_API.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findByUserName(String userName);

    User findByEmail(String email);
}
