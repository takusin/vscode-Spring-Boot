package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.app.domain.Password;
import com.example.app.domain.Users;
import com.example.app.mapper.PasswordMapper;
import com.example.app.mapper.UsersMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequiredArgsConstructor
public class RegisterController {
    
    private final UsersMapper userMapper;
    private final PasswordMapper passwordMapper;

    @GetMapping("register")
    public String register(Model model) {
        model.addAttribute("users", new Users());
        model.addAttribute("password", new Password());
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute Users user) {
        //ユーザーネームを追加
        userMapper.addUser(user);
        //パスワード登録
        // passwordMapper.addPassword(user.getId());
        return "redirect:/login";
    }
    

    
}
