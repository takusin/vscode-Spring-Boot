package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToDoController {
    
    @GetMapping("/addTodo")
    public String getMethodName() {
        return "addToDo";
    }
    
}
