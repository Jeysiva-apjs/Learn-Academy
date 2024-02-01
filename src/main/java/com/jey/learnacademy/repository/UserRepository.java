package com.jey.learnacademy.repository;

import org.springframework.data.repository.CrudRepository;

import com.jey.learnacademy.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

    
} 
