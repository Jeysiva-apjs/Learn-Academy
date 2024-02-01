package com.jey.learnacademy.service;

import com.jey.learnacademy.entity.Admin;

public interface AdminService {
    String createAdmin(Admin admin); 
    String loginAdmin(String email, String password);  
} 
