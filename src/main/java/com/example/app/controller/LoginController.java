package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.User;
import com.example.app.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserServiceImpl userService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        //エラーオブジェクトが存在すればもう一度モデルに再格納
        if(model.containsAttribute("loginError")){
            model.addAttribute("loginError", model.asMap().get("loginError"));
        }
        return "login";
    }

    @PostMapping("/myPage")
    public String processLogin(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        //サービスクラスのログイン処理の結果を格納
        boolean pass = userService.canUserLogin(user);
        if(!pass){
            //失敗ならログイン画面にリダイレクト
            redirectAttributes.addFlashAttribute("loginError", "ユーザーネームかパスワードが違います");
            return "redirect:/login";
        }
        return "myPage";
    }

}
