package com.example.app.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Users;

@Mapper
public interface UserInfoMapper {
    
    void addUser(Users user);

}
