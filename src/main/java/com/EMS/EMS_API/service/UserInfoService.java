package com.EMS.EMS_API.service;

import com.EMS.EMS_API.entity.User;
import com.EMS.EMS_API.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

    @Service
    public class UserInfoService implements UserDetailsService {

        @Autowired
        private UserRepo repository;


        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            User user = repository.findByName(username);

            // Converting userDetail to UserDetails
            return user;
         //   return userDetail(UserInfoDetails::new)
         //           .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
        }


    }

