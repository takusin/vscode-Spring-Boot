package com.example.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.Todo;
import com.example.app.domain.User;
import com.example.app.service.TodoService;
import com.example.app.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    private final TodoService todoService;

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
    public String processLogin(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes, HttpSession session) {
        //サービスクラスのログイン処理の結果を格納
        boolean pass = userService.canUserLogin(user);
        if(!pass){
            //失敗ならログイン画面にリダイレクト
            redirectAttributes.addFlashAttribute("loginError", "ユーザーネームかパスワードが違います");
            return "redirect:/login";
        } else {
            // ログイン成功時にユーザーIDをセッションに格納
            session.setAttribute("userId", user.getId());
            return "redirect:/myPage";
        }
        
    }

    @GetMapping("/myPage")
    public String myPage(Model model, HttpSession session) {
        // セッションからユーザーIDを取得
        Integer userId = (Integer) session.getAttribute("userId");

        // ユーザーIDをもとにToDoタイトルリストを取得
        List<Todo> uncompleteds = todoService.findUncompletedTitlesByUserId(userId); // 未完了リスト
        List<Todo> completeds = todoService.findCompletedTitlesByUserId(userId); // 完了リスト

        // モデルにToDoリストを追加
        model.addAttribute("uncompleteds", uncompleteds);
        model.addAttribute("completeds", completeds);

        return "myPage";
    }
    

}
