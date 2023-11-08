package com.EMS.EMS_API.service;

import com.EMS.EMS_API.entity.UserInfo;
import com.EMS.EMS_API.repository.UserInfoRepository;
import com.EMS.EMS_API.vo.UserInfoDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

    @Service
    public class UserInfoService implements UserDetailsService {

        @Autowired
        private UserInfoRepository repository;

        @Autowired
        private PasswordEncoder encoder;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            UserInfo userDetail = repository.findByName(username).get();

            // Converting userDetail to UserDetails
            return userDetail(UserInfoDetails::new)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
        }

        public String addUser(UserInfo userInfo) {
            userInfo.setPassword(encoder.encode(userInfo.getPassword()));
            repository.save(userInfo);
            return "User Added Successfully";
        }


    }


