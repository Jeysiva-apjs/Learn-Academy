package com.jey.learnacademy.repository;

import org.springframework.data.repository.CrudRepository;

import com.jey.learnacademy.entity.Admin;

public interface AdminRepository extends CrudRepository<Admin, Long>{
    
}
