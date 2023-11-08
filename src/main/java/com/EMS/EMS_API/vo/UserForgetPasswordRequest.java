package com.EMS.EMS_API.vo;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
public class UserForgetPasswordRequest {

   private String email ;
   @DateTimeFormat(pattern="dd-MM-yyyy")
   private LocalDate dob = LocalDate.now();
}
