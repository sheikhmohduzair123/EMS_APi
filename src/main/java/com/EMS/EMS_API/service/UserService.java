package com.EMS.EMS_API.service;

import com.EMS.EMS_API.entity.User;
import com.EMS.EMS_API.repository.UserRepo;
import com.EMS.EMS_API.vo.UserLoginRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;
@Service
public class UserService {


    private final UserRepo userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public UserService(
            UserRepo userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
   /* public User getUserByUserName(String userName) {
    }*/

    public User getUserById(Long id) {
      return   this.userRepository.findById(id).get();
    }

    /*public void updateUser(Long id, User updatedUser) {
        this.userRepository
    }*/
   /*
    public void updateUserPassword(Long id, String hashedPassword) {
    }

    public List<User> getAllUsers() {
    }

    public User getUserByEmail(String email) {

    }*/

    public User login(UserLoginRequest userLoginRequest) {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userLoginRequest.getUserName(),
                            userLoginRequest.getPassword()
                    )
            );

            return userRepository.findByName(userLoginRequest.getUserName());

        }

    public void registerUser(User usr) {
        System.out.println("hello");
        this.userRepository.save(usr);

    }
}

