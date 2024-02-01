package com.jey.learnacademy.service;

import java.util.List;
import java.util.Set;

import com.jey.learnacademy.entity.Course;

public interface CourseService {

    String createCourse(Long adminId, Course course);
    Course getCourse(Long id);
    String updateCourse(Long id, Course course);
    String deleteCourse(Long id);
    List<Course> getAllCourses();
    List<Course> getPublishedCourses();
    String purchaseCourse(Long userId, Long courseId);
    Set<Course> getPurchasedCourses(Long userId);
    
} 
