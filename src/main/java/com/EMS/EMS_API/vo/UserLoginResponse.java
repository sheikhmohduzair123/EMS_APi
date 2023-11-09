package com.EMS.EMS_API.vo;

import com.EMS.EMS_API.entity.User;

public class UserLoginResponse {
    private User authenticatedUser;
    private String token;

    private String status;

    public UserLoginResponse(String token, String status) {
        this.token = token;
        this.status = status;
    }

    public UserLoginResponse(String status) {
       this. status = status;
    }

    public UserLoginResponse(User authenticatedUser, String token, String status) {
    }
}
