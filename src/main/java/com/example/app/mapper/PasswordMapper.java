package com.example.app.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.User;

@Mapper
public interface PasswordMapper {
    //パスワード追加
    void addPassword(User user);

    //パスワード検索
    String selectById(int userId);
}
