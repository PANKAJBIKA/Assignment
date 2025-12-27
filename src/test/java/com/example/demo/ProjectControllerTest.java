package com.example.demo;

import com.example.workspace.project.Project;
import com.example.workspace.project.ProjectService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProjectServiceTest projectService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createProject_shouldReturn200() throws Exception {

        Project project = new Project();
        project.setName("Demo");

        when(projectService.create(any(Project.class)))
                .thenReturn(project);

        mockMvc.perform(post("/projects")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(project)))
                .andExpect(status().isOk());
    }
}
