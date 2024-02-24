package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.app.domain.Todo;

@Mapper
public interface TodosMapper {
    
    // todoリスト追加
    void insertTodo(Todo todo);

    // ユーザーIDに基づいてTodoのタイトルを全件取得
    List<Todo> findTitlesByUserId(@Param("userId") Integer userId);

    // ユーザーIDに基づいて未完了（status=0）のTodoのタイトルを取得
    List<Todo> findUncompletedTitlesByUserId(@Param("userId") Integer userId);

    // ユーザーIDに基づいて完了（status=1）のTodoのタイトルを取得
    List<Todo> findCompletedTitlesByUserId(@Param("userId") Integer userId);

    // idに基づいてtodoの内容を取得
    Todo findById(@Param("id") Integer id);

    // idに基づいてtodoの内容を変更
    void updateTodo(Todo todo);

    // IDに基づいてTodoのstatusを変更
    void updateTodoStatus(Todo todo);

    // IDに基づいてTodoを削除
    void deleteTodoById(Integer id);

} 