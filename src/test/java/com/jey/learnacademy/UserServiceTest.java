package com.jey.learnacademy;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.jey.learnacademy.entity.User;
import com.jey.learnacademy.exception.UserNotFoundException;
import com.jey.learnacademy.repository.UserRepository;
import com.jey.learnacademy.service.UserServiceImpl;

@SpringBootTest
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void should_CreateAdmin_WhenCorrectInput(){
        // Arrange
        User user = new User("user@gmail.com", "password");
        when(userRepository.save(user)).thenReturn(user);

        // Act
        String actual = userService.createUser(user);

        // Assert
        assertEquals("User created successfully", actual);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void should_LoginAdmin_WhenCorrectInput(){
        // Arrange
        User user = new User("admin@gmail.com", "password");
        when(userRepository.findAll()).thenReturn(Arrays.asList(user));

        // Act
        String actual = userService.loginUser(user.getEmail(), user.getPassword());
        assertEquals("Logged in successfully", actual);

        // Assert
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void should_ThrowUserNotFoundException_WhenAdminNotPresent(){
        // Arrange
        String email = "admin@gmail.com";
        String password = "password";
        when(userRepository.findAll()).thenReturn(Collections.emptyList());

        // Act and Assert
        assertThrows(UserNotFoundException.class, () -> {
            userService.loginUser(email, password);
        });
        verify(userRepository, times(1)).findAll();
    }
}
