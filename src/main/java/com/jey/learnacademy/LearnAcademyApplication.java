package com.jey.learnacademy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jey.learnacademy.entity.Admin;
import com.jey.learnacademy.entity.Course;
import com.jey.learnacademy.entity.User;
import com.jey.learnacademy.service.AdminService;
import com.jey.learnacademy.service.CourseService;
import com.jey.learnacademy.service.UserService;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class LearnAcademyApplication implements CommandLineRunner{

	private UserService userService;
	private CourseService courseService;
	private AdminService adminService;

	public static void main(String[] args) {
		SpringApplication.run(LearnAcademyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.createUser(new User("user", "pass"));
		adminService.createAdmin(new Admin("admin", "pass"));

		courseService.createCourse(1l, new Course("Java", "Java for beginners", 100.00, true));
		courseService.createCourse(1l,new Course("Python", "Python for beginners", 200.00, true));
		courseService.createCourse(1l,new Course("JavaScript", "JavaScript for beginners", 300.00, true));
		courseService.createCourse(1l,new Course("C++", "C++ for beginners", 400.00, true));
		courseService.createCourse(1l,new Course("C#", "C# for beginners", 500.00, true));
		courseService.createCourse(1l,new Course("Ruby", "Ruby for beginners", 600.00, true));
		courseService.createCourse(1l,new Course("PHP", "PHP for beginners", 700.00, true));
		courseService.createCourse(1l,new Course("Swift", "Swift for beginners", 800.00, true));
		courseService.createCourse(1l,new Course("Kotlin", "Kotlin for beginners", 900.00, true));
		courseService.createCourse(1l,new Course("Go", "Go for beginners", 1000.00, true));

		courseService.purchaseCourse(1L, 1L);
		courseService.purchaseCourse(1L, 2L);
		courseService.purchaseCourse(1L, 3L);
		courseService.purchaseCourse(1L, 4L);
		courseService.purchaseCourse(1L, 5L);
		
		
	}

}
