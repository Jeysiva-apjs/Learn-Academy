package com.jey.learnacademy;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.jey.learnacademy.entity.Admin;
import com.jey.learnacademy.exception.AdminNotFoundException;
import com.jey.learnacademy.repository.AdminRepository;
import com.jey.learnacademy.service.AdminServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class AdminServiceTest {

    @Mock
    private AdminRepository adminRepository;

    @InjectMocks
    private AdminServiceImpl adminService;

    @Test
    public void should_CreateAdmin_WhenCorrectInput(){
        // Arrange
        Admin admin = new Admin("admin@gmail.com", "password");
        when(adminRepository.save(admin)).thenReturn(admin);

        // Act
        String actual = adminService.createAdmin(admin);

        // Assert
        assertEquals("Admin created successfully", actual);
        verify(adminRepository, times(1)).save(admin);
    }

    @Test
    public void should_LoginAdmin_WhenCorrectInput(){
        // Arrange
        Admin admin = new Admin("admin@gmail.com", "password");
        when(adminRepository.findAll()).thenReturn(Arrays.asList(admin));

        // Act
        String actual = adminService.loginAdmin(admin.getEmail(), admin.getPassword());

        // Assert
        assertEquals("Logged in successfully", actual);
        verify(adminRepository, times(1)).findAll();
    }

    @Test
    public void should_ThrowAdminNotFoundException_WhenAdminNotPresent(){
        // Arrange
        String email = "admin@gmail.com";
        String password = "password";
        when(adminRepository.findAll()).thenReturn(Collections.emptyList());

        // Act and Assert
        assertThrows(AdminNotFoundException.class, () -> {
            adminService.loginAdmin(email, password);
        });
        verify(adminRepository, times(1)).findAll();
    }

}
