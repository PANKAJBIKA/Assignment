package com.example.demo;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    @Test
    void getProjectById_shouldReturnProject() {
        Project project = new Project();
        project.setId(1L);
        project.setName("Test Project");

        when(projectRepository.findById(1L))
                .thenReturn(Optional.of(project));

        Project result = projectService.get(1L);

        assertNotNull(result);
        assertEquals("Test Project", result.getName());
    }
}
