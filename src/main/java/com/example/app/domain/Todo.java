package com.example.app.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Todo {
    private Integer id;
    private Integer userId;
    private String title;
    private String description;
    private Integer status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
