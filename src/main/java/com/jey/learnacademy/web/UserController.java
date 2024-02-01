package com.jey.learnacademy.web;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jey.learnacademy.entity.Course;
import com.jey.learnacademy.entity.User;
import com.jey.learnacademy.service.CourseService;
import com.jey.learnacademy.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private CourseService courseService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody User  user) {  
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.loginUser(user.getEmail(), user.getPassword()), HttpStatus.OK);
    }

    @GetMapping("/courses/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @PostMapping("{userId}/purchaseCourses/{courseId}")
    public ResponseEntity<String> purchaseCourse(@PathVariable Long userId, @PathVariable Long courseId) {
        return new ResponseEntity<>(courseService.purchaseCourse(userId, courseId), HttpStatus.OK);
    }

    @GetMapping("{userId}/purchasedCourses")
    public ResponseEntity<Set<Course>> getPurchasedCourse(@PathVariable Long userId) {
        return new ResponseEntity<>(courseService.getPurchasedCourses(userId), HttpStatus.OK);
    }
    
}
