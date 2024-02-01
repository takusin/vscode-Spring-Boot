package com.example.app.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;

    @GetMapping("register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@RequestParam("username") String userName, @RequestParam("password") String passwordStr) {
        userService.registerUser(userName, passwordStr);
        return "redirect:/login";
    }

}
