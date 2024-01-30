package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.app.domain.Password;
import com.example.app.domain.Users;


@Controller
public class RegisterController {
    
    @GetMapping("register")
    public String register(Model model) {
        model.addAttribute("users", new Users());
        model.addAttribute("password", new Password());
        return "register";
    }
    
}
