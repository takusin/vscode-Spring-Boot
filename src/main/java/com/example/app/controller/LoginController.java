package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.User;
import com.example.app.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/myPage")
    public String processLogin(@ModelAttribute("user") User user) {
        //サービスクラスのログイン処理の結果を格納
        boolean pass = userService.canUserLogin(user);
        if(!pass){
            //失敗ならログイン画面にリダイレクト
            return "redirect:/login";
        }
        return "myPage";
    }

}
