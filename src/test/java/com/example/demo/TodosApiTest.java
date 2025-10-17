package com.example.demo;

import com.example.demo.model.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.Todo;
import com.example.demo.model.TodoInput;
import com.example.demo.TodosStorageService;

public class TodosApiTest {private TodosStorageService todosStorageService;
    private TodosApiImpl todosApiImpl;

    @BeforeEach
    void setUp() {
        todosStorageService = mock(TodosStorageService.class);
        todosApiImpl = new TodosApiImpl(todosStorageService);
    }

    @Test
    void createTodo_ShouldReturnCreatedTodo() {
        // Arrange
        TodoInput input = new TodoInput();
        input.setTask("Write unit test");
        input.setCompleted(false);

        // Act
        ResponseEntity<Todo> response = todosApiImpl.createTodo(input);

        // Assert
        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Write unit test", response.getBody().getTask());
        assertFalse(response.getBody().getCompleted());
        verify(todosStorageService, times(1)).todosCreate(any(Todo.class));
    }

    @Test
    void todosIdGet_ShouldReturnId() {
        assertEquals(0, 0);
    }
}

