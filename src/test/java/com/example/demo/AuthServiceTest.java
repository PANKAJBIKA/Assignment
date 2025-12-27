package com.example.demo;

import com.example.workspace.config.JwtUtil;
import com.example.workspace.user.User;
import com.example.workspace.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private AuthServiceTest authService;

    @Test
    void registerUser_shouldReturnJwtToken() {
        when(jwtUtil.generateToken("pankaj")).thenReturn("mock-token");

        String token = authService.register("pankaj", "1234");

        assertEquals("mock-token", token);
        verify(userRepository, times(1)).save(any(User.class));
    }
}
