package com.example.app.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Users;


@Mapper
public interface UsersMapper {
    
    //ユーザー追加
    void addUser(Users user);

    //ユーザー検索(ID)
    Users selectById(int id);
}
