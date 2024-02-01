package com.jey.learnacademy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jey.learnacademy.entity.User;
import com.jey.learnacademy.exception.UserNotFoundException;
import com.jey.learnacademy.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Override
    public String createUser(User user) {
        userRepository.save(user);
        return "User created successfully";
    }

    @Override
    public String loginUser(String email, String password) {
        List<User> users = (List<User>)userRepository.findAll();
        if(users.isEmpty()){
            throw new UserNotFoundException(email);
        }
        User user = users.stream().filter(a -> a.getEmail().equals(email) 
        && a.getPassword().equals(password)).findFirst().orElse(null);

        if(user == null){
            throw new UserNotFoundException(email);   
        }

        return "Logged in successfully";
    }
}
