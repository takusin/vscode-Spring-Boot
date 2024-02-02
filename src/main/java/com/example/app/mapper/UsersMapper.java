package com.example.app.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.User;


@Mapper
public interface UsersMapper {
    
    //ユーザー追加
    void addUser(User user);
    
}
