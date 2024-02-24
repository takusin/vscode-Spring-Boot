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
    public List<Todo> findUncompletedTitlesByUserId(Integer userId) {
        return todosMapper.findUncompletedTitlesByUserId(userId);
    }

    @Override
    public List<Todo> findCompletedTitlesByUserId(Integer userId) {
        return todosMapper.findCompletedTitlesByUserId(userId);
    }

    @Override
    public Todo findById(Integer id) {
        return todosMapper.findById(id);
    }

    @Override
    public void editTodo(Todo todo){
        todosMapper.updateTodo(todo);
    }

    @Override
    public void updateTodoStatus(Integer id, Integer status) {
        Todo todo = new Todo();
        todo.setId(id);
        todo.setStatus(status);
        todosMapper.updateTodoStatus(todo); // マッパーのupdateTodoStatusメソッドを呼び出し
    }

    @Override
    public void deleteTodoById(Integer id){
        todosMapper.deleteTodoById(id);
    }

}
