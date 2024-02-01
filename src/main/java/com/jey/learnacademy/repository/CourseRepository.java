package com.jey.learnacademy.repository;

import org.springframework.data.repository.CrudRepository;

import com.jey.learnacademy.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Long>{
  
} 
