package com.example.app.service;

import com.example.app.domain.User;

public interface UserService {

    //ユーザー登録
    public void registerUser(User user);
    
    //ログイン処理
    public boolean canUserLogin(User user);
}
