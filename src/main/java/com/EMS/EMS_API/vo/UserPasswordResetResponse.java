package com.EMS.EMS_API.vo;

import lombok.Data;

@Data
public class UserPasswordResetResponse {
    private String verifiedUser;

    private  String success;

    private String token;

    public UserPasswordResetResponse(String verifiedUser, String success, String token) {
    }
    public UserPasswordResetResponse(String verifiedUser, String success) {
    }
}
