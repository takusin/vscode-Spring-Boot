package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.UserInfo;

import jakarta.validation.Valid;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userInfo", new UserInfo());
        return "login";
    }

    @PostMapping("/myPage")
    public String myPage(@Valid @ModelAttribute UserInfo userInfo, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("userInfo", userInfo);
            return "login";
        }
        return "myPage";
    }

}
