package com.jey.learnacademy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jey.learnacademy.entity.Admin;
import com.jey.learnacademy.exception.AdminNotFoundException;
import com.jey.learnacademy.repository.AdminRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AdminServiceImpl implements AdminService{

    AdminRepository adminRepository;

    @Override
    public String createAdmin(Admin admin) {
        adminRepository.save(admin);
        return "Admin created successfully";
    }

    @Override
    public String loginAdmin(String email, String password) {
        List<Admin> admins = (List<Admin>)adminRepository.findAll();
        if(admins.isEmpty()){
            throw new AdminNotFoundException(email);
        }
        Admin admin = admins.stream().filter(a -> a.getEmail().equals(email) 
        && a.getPassword().equals(password)).findFirst().orElse(null);

        if(admin == null){
            throw new AdminNotFoundException(email + " " + password);
        }
        return "Logged in successfully";
    }
    
}
