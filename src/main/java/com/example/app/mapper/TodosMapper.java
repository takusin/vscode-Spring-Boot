package com.example.app.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Todo;

@Mapper
public interface TodosMapper {
    
    //todoリスト追加
    void insertTodo(Todo todo);
} 