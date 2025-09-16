//package com.learn.springboot.demosecurity.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//    @Autowired
//    private JdbcUserDetailsManager userDetailsManager;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    // DTO to accept JSON payload
//    public static class CreateUserRequest {
//        public String username;
//        public String password;
//        public String[] roles;
//    }
//
//    @PostMapping
//    public String createUser(@RequestBody CreateUserRequest req){
//        if(userDetailsManager.userExists(req.username)){
//            return "User already exists";
//        }
//
//        UserDetails userDetails = User.builder()
//                .username(req.username)
//                .password(passwordEncoder.encode(req.password))
//                .roles(req.roles)
//                .build();
//
//        userDetailsManager.createUser(userDetails);
//        return "User created";
//    }
//
//}
