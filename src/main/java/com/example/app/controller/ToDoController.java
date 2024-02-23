package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.Todo;
import com.example.app.service.TodoService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ToDoController {
    
    private final TodoService todoService;

    @GetMapping("/addTodo")
    public String showAddTodoForm(HttpSession session, Model model) {
        // セッションからuserIdを取得
        Integer userId = (Integer) session.getAttribute("userId");
        // ModelにuserIdを追加
        model.addAttribute("userId", userId);
        // 新しいTodoオブジェクトをモデルに追加
        model.addAttribute("todo", new Todo());
        
        return "addTodo";
    }

    @PostMapping("/addTodo")
    public String addTodo(@ModelAttribute("todo") Todo todo, HttpSession session) {
        // セッションからuserIdを取得
        Integer userId = (Integer) session.getAttribute("userId");
        todoService.addTodo(todo, userId);
        return "redirect:/myPage";
    }
    
}
