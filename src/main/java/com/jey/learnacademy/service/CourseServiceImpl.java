package com.jey.learnacademy.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jey.learnacademy.entity.Course;
import com.jey.learnacademy.entity.User;
import com.jey.learnacademy.exception.CourseNotFoundException;
import com.jey.learnacademy.exception.UserNotFoundException;
import com.jey.learnacademy.repository.CourseRepository;
import com.jey.learnacademy.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;
    private UserRepository userRepository;

    @Override
    public String createCourse(Long adminId, Course course) {
        courseRepository.save(course);
        return "Course deleted successfully";
    }

    @Override
    public Course getCourse(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
    }

    @Override
    public List<Course> getAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public List<Course> getPublishedCourses() {
        List<Course> courses = (List<Course>) courseRepository.findAll();
        return courses.stream().filter(course -> course.isPublished() == true).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public String purchaseCourse(Long userId, Long courseId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException(userId));
        Course course = courseRepository.findById(courseId).orElseThrow(()-> new CourseNotFoundException(courseId));
        course.getUsers().add(user);
        courseRepository.save(course);
        return "Course purchased successfully";
    }

    @Override
    public Set<Course> getPurchasedCourses(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException(userId));
        return user.getCourses();
    }

    @Override
    public String updateCourse(Long id, Course course) {
        Course updateCourse = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        updateCourse.setTitle(course.getTitle());
        updateCourse.setDescription(course.getDescription());
        updateCourse.setPrice(course.getPrice());
        updateCourse.setPublished(course.isPublished());
        courseRepository.save(updateCourse);
        return "Course updated successfully";
    }

    @Override
    public String deleteCourse(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        courseRepository.delete(course);
        return "Course deleted successfully";
    }
    
}
