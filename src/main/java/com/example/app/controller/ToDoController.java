package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.app.domain.Todo;

import jakarta.servlet.http.HttpSession;

@Controller
public class ToDoController {
    
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
    
}
