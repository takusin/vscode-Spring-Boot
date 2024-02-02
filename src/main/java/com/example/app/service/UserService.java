package com.example.app.service;

import org.springframework.stereotype.Service;

import com.example.app.domain.User;
import com.example.app.mapper.PasswordMapper;
import com.example.app.mapper.UsersMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UsersMapper usersMapper;
    private final PasswordMapper passwordMapper;

    public void registerUser(User user){
        //ユーザーテーブルに追加
        usersMapper.addUser(user);

        //パスワードテーブルに追加
        user.setId(user.getId()); //addUserでセットしたID
        passwordMapper.addPassword(user);
    }

    public boolean canUserLogin(User user){
        return false;
    }
}
