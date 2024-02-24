package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.Todo;
import com.example.app.service.MarkdownService;
import com.example.app.service.TodoService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ToDoController {
    
    private final TodoService todoService;

    private final MarkdownService markdownService;

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

    @GetMapping("/todo/{id}")
    public String todoDetail(@PathVariable("id") Integer id, Model model) {
        // IDに基づいてToDoアイテムの詳細情報を取得
        Todo todo = todoService.findById(id);

        // ToDoアイテムのdescriptionをマークダウンからHTMLに変換
        String htmlDescription = markdownService.markdownToHtml(todo.getDescription());
        todo.setDescription(htmlDescription); // 変換後のHTMLをToDoアイテムにセット

        // モデルにToDoアイテムを追加
        model.addAttribute("todo", todo);

        // ToDo詳細ページに遷移
        return "todoDetail";
    }

    @GetMapping("/todo/edit/{id}")
    public String showEditTodoForm(@PathVariable("id") Integer id, Model model) {
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        return "editTodo";
    }

    @PostMapping("/edit/{id}")
    public String updateTodo(@PathVariable("id") Integer id, Todo todo, RedirectAttributes redirectAttributes) {
        todo.setId(id); // URLから取得したidをセット
        todoService.editTodo(todo); // 編集内容を更新
        redirectAttributes.addFlashAttribute("successMessage", "ToDoが更新されました。");
        return "redirect:/todo/" + id; // ToDo詳細画面にリダイレクト
    }
    
    @PostMapping("/todo/status/{id}")
    public String updateTodoStatus(
        @PathVariable("id") Integer id, 
        @ModelAttribute("status") Integer status, 
        RedirectAttributes redirectAttributes) {

        todoService.updateTodoStatus(id, status); // ステータスを更新
        redirectAttributes.addFlashAttribute("successMessage", "ToDoのステータスが更新されました。");
        return "redirect:/todo/" + id; // ToDo詳細画面にリダイレクト
        
    }

}
