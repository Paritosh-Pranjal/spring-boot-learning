package com.learn.springboot.demosecurity.service;

import com.learn.springboot.demosecurity.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findBUserName(String username);
}
