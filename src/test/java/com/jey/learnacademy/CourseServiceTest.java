package com.jey.learnacademy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.jey.learnacademy.entity.Course;
import com.jey.learnacademy.exception.CourseNotFoundException;
import com.jey.learnacademy.repository.CourseRepository;
import com.jey.learnacademy.repository.UserRepository;
import com.jey.learnacademy.service.CourseServiceImpl;

@SpringBootTest
public class CourseServiceTest {
    
    @Mock
    private CourseRepository courseRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CourseServiceImpl courseService;

    @Test
    public void should_ReturnCourse_WhenCorrectId(){
        // Arrange
        long courseId = 1L;
        Course course = new Course("Java", "Java for beginners", 100.00, true);
        when(courseRepository.findById(courseId)).thenReturn(Optional.of(course));

        // Act
        Course actual = courseService.getCourse(courseId);

        // Assert
        assertEquals(course, actual);
    }

    @Test
    public void should_ThrowCourseNotFoundException_WhenCorrectNotFound(){
        // Arrange
        when(courseRepository.findById(1l)).thenThrow(CourseNotFoundException.class);

        // Act and Assert
        assertThrows(CourseNotFoundException.class, () -> courseService.getCourse(1l));
    }

    @Test
    public void should_ReturnAllCourses_WhenGetAllCourses(){
        // Arrange
        List<Course> courses = new ArrayList<>(List.of(new Course("Java", "Java for beginners", 100.00, true), 
        new Course("Python", "Python for beginners", 200.00, true)));

        when(courseRepository.findAll()).thenReturn(courses);

        // Act
        List<Course> actual = courseService.getAllCourses();

        // Assert
        assertAll("Courses",
            () -> assertEquals(courses.size(), actual.size()),
            () -> assertEquals(courses.get(0).getId(), actual.get(0).getId()),
            () -> assertEquals(courses.get(1).getId(), actual.get(1).getId())
        );
    }

    @Test
    public void should_ReturnPublishedCourses_WhenGetPublishedCourses(){
        // Arrange
        List<Course> courses = new ArrayList<>(List.of(new Course("Java", "Java for beginners", 100.00, true), 
        new Course("Python", "Python for beginners", 200.00, false)));

        when(courseRepository.findAll()).thenReturn(courses);

        // Act
        List<Course> actual = courseService.getPublishedCourses();

        // Assert
        assertAll("Courses",
            () -> assertEquals(1, actual.size()),
            () -> assertEquals(courses.get(0).getId(), actual.get(0).getId())
        );
    }

    @Test
    public void should_DeleteCourse_WhenCorrectId() {
    // Arrange
    long courseId = 1L;
    Course course = new Course("Java", "Java for beginners", 100.00, true);
    when(courseRepository.findById(courseId)).thenReturn(Optional.of(course));

    // Act
    String result = courseService.deleteCourse(courseId);

    // Assert
    assertEquals("Course deleted successfully", result);
    verify(courseRepository, times(1)).delete(course);
}


    
}
