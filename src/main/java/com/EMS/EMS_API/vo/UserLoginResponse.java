package com.EMS.EMS_API.vo;

import com.EMS.EMS_API.entity.User;
import lombok.Data;

@Data
public class UserLoginResponse {

        private User verifiedUser; // Change the type to User
        private String success;
        private String token;

    public UserLoginResponse(String success, String token) {
        this.success = success;
        this.token = token;
    }

    public UserLoginResponse(User verifiedUser, String success, String token) {
            this.verifiedUser = verifiedUser;
            this.success = success;
            this.token = token;
        }

        public UserLoginResponse(User verifiedUser, String success) {
            this.verifiedUser = verifiedUser;
            this.success = success;
        }
    }


