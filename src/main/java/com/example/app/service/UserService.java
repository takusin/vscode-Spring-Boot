package com.example.app.service;

import org.springframework.stereotype.Service;

import com.example.app.domain.Password;
import com.example.app.domain.Users;
import com.example.app.mapper.PasswordMapper;
import com.example.app.mapper.UsersMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UsersMapper usersMapper;
    private final PasswordMapper passwordMapper;

    public void registerUser(String userName, String passwordStr){
        Users users = new Users();
        users.setName(userName);
        usersMapper.addUser(users);

        Password password = new Password();
        password.setPassword(passwordStr);
        password.setUserId(users.getId()); //addUserでセットしたID
        passwordMapper.addPassword(password);
    }

    public boolean canUserLogin(String userName, String passwordStr){
        return false;
    }
}
