package com.example.app.service;

import java.util.List;

import com.example.app.domain.Todo;

public interface TodoService {
    // ToDoアイテムを追加するメソッド
    void addTodo(Todo todo, Integer userId);

    // ユーザーIDに基づいてTodoのタイトルとIDを全件取得
    List<Todo> findTitlesByUserId(Integer userId);

    // TodoのIDに基づいてTodoの詳細情報を取得
    Todo findById(Integer id);

    // ToDoアイテムを更新するメソッドの追加
    void editTodo(Todo todo);

    // ステータス更新メソッドの追加
    void updateTodoStatus(Integer id, Integer status); 
}
