package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.domain.Todo;
import com.example.app.mapper.TodosMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodosMapper todosMapper;

    @Override
    public void addTodo(Todo todo, Integer userId) {
        todo.setUserId(userId);
        todosMapper.insertTodo(todo);
    }

    @Override
    public List<Todo> findTitlesByUserId(Integer userId) {
        return todosMapper.findTitlesByUserId(userId);
    }

    @Override
    public Todo findById(Integer id) {
        return todosMapper.findById(id);
    }

}
