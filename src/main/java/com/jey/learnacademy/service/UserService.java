package com.jey.learnacademy.service;

import com.jey.learnacademy.entity.User;

public interface UserService {
    String createUser(User user);
    String loginUser(String email, String password);  
}
