package com.example.app.service;

import org.springframework.stereotype.Service;

import com.example.app.domain.Todo;
import com.example.app.mapper.TodosMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodosMapper todosMapper;

    @Override
    public void addTodo(Todo todo) {
        todosMapper.insertTodo(todo);
    }
}
