package com.EMS.EMS_API.service;

import com.EMS.EMS_API.entity.User;
import com.EMS.EMS_API.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User getUserByUserName(String userName) {
        return userRepo.findByUserName(userName);
    }

    public User getUserById(Long id) {
        
        return userRepo.findById(id).orElse(null);
    }

    public void updateUser(Long id, User updatedUser) {
        
        User existingUser = userRepo.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setName(updatedUser.getName());
            existingUser.setUserName(updatedUser.getUserName());
            existingUser.setEmail(updatedUser.getEmail());
            userRepo.save(existingUser);
        }
    }

    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }
}

