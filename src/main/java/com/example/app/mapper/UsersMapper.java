package com.example.app.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.User;


@Mapper
public interface UsersMapper {
    
    //ユーザー追加
    void addUser(User user);
    
    //ユーザー検索
    Integer selectByName(String userName);
}
