package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.app.domain.Todo;

@Mapper
public interface TodosMapper {
    
    //todoリスト追加
    void insertTodo(Todo todo);

    // ユーザーIDに基づいてTodoのタイトルを全件取得
    List<Todo> findTitlesByUserId(@Param("userId") Integer userId);
} 