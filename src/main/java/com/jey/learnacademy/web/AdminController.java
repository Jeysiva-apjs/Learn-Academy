package com.jey.learnacademy.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jey.learnacademy.entity.Admin;
import com.jey.learnacademy.entity.Course;
import com.jey.learnacademy.service.AdminService;
import com.jey.learnacademy.service.CourseService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private AdminService adminService;
    private CourseService courseService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody Admin admin) {  
        return new ResponseEntity<>(adminService.createAdmin(admin), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody Admin admin) {
       return new ResponseEntity<>(adminService.loginAdmin(admin.getEmail(), admin.getPassword()), 
       HttpStatus.OK);
    }

    @PostMapping("/courses/create/{adminId}")
    public ResponseEntity<String> createCourse(@PathVariable Long adminId, @Valid @RequestBody Course course) {
        courseService.createCourse(adminId, course);
        return new ResponseEntity<>("Course created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/courses/update/{courseId}")
    public ResponseEntity<String> updateCourse(@PathVariable Long courseId, @Valid @RequestBody Course course) {
        return new ResponseEntity<>(courseService.updateCourse(courseId, course), HttpStatus.OK);
    }

    @DeleteMapping("/courses/delete/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long courseId) {
        return new ResponseEntity<>(courseService.deleteCourse(courseId), HttpStatus.OK);
    }

    @GetMapping("/courses/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

}
