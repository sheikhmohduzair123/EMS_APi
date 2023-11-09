package com.EMS.EMS_API.conroller;

import com.EMS.EMS_API.entity.User;
import com.EMS.EMS_API.service.UserService;
import com.EMS.EMS_API.utils.JwtService;
import com.EMS.EMS_API.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
    @RequestMapping("/users")
    public class UserController {

        private final UserService userService;

        private final JwtService jwtService;

        @Autowired
        public UserController(UserService userService, JwtService jwtService) {
            this.userService = userService;
            this.jwtService = jwtService;
        }


    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> loginUser(@RequestBody UserLoginRequest userLoginRequest) {
        try {
            User authenticatedUser = this.userService.login(userLoginRequest);

            if (authenticatedUser == null) {
                return new ResponseEntity<>(new UserLoginResponse("Username is required.", "error"), HttpStatus.BAD_REQUEST);
            }

            String inputPassword = userLoginRequest.getPassword();

            String token = jwtService.generateToken(authenticatedUser.getUsername()); // Implement your JWT token generation logic here
            return new ResponseEntity<>(new UserLoginResponse(authenticatedUser, token, "success"), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new UserLoginResponse("Internal server error.", "error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


     @PostMapping("/register")
        public ResponseEntity<Void> registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
           try {
                String name = userRegistrationRequest.getName();
                String userName = userRegistrationRequest.getUserName();
                String mobile = userRegistrationRequest.getMobile();
                String email = userRegistrationRequest.getEmail();
                String password = userRegistrationRequest.getPassword();

                User usr=new User(name,userName,mobile,email,password);


                userService.registerUser(usr);

                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        }

   /* @PutMapping("/{id}")
        public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody UserUpdateRequest userUpdateRequest) {
            try {
                User user = userService.getUserById(id);

                if (user == null) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }

                String name = userUpdateRequest.getName();
                String userName = userUpdateRequest.getUserName();
                String mobile = userUpdateRequest.getMobile();
                String email = userUpdateRequest.getEmail();

                User updatedUser = new User(name, userName, mobile, email);
                userService.updateUser(id, updatedUser);

                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
*/

           /* @PostMapping("/forget-password")
            public ResponseEntity<UserPasswordResetResponse> forgetPassword(@RequestBody UserForgetPasswordRequest forgetPasswordRequest) {
                try {
                    String email = forgetPasswordRequest.getEmail();
                    String dob = String.valueOf(forgetPasswordRequest.getDob());

                    User user = userService.getUserByEmail(email);

                    if (user != null) {
                        LocalDate userDob = user.getDob();
                        Date dobInput = new Date(dob);
                        if (userDob.equals(dobInput)) {
                            String token = "your-jwt-token-generation"; // Implement your JWT token generation logic here
                            return new ResponseEntity<>(new UserPasswordResetResponse("Verified User", "success", token), HttpStatus.OK);
                        } else {
                            return new ResponseEntity<>(new UserPasswordResetResponse("Unauthorized User", "error"), HttpStatus.UNAUTHORIZED);
                        }
                    } else {
                        return new ResponseEntity<>(new UserPasswordResetResponse("User not found", "error"), HttpStatus.NOT_FOUND);
                    }
                } catch (Exception e) {
                    return new ResponseEntity<>(new UserPasswordResetResponse("Internal server error", "error"), HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }*/

            @GetMapping("/{id}")
            public ResponseEntity<User> getUserById(@PathVariable Long id) {
                try {
                    User user = userService.getUserById(id);

                    if (user == null) {
                        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                    }

                    return new ResponseEntity<>(user, HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        }

