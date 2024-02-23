package com.example.app.service;

import com.example.app.domain.Todo;

public interface TodoService {
    // ToDoアイテムを追加するメソッド
    void addTodo(Todo todo, Integer userId);
}
