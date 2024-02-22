package com.example.app.service;

import org.springframework.stereotype.Service;

import com.example.app.domain.User;
import com.example.app.mapper.PasswordMapper;
import com.example.app.mapper.UsersMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    
    private final UsersMapper usersMapper;
    private final PasswordMapper passwordMapper;

    @Override
    public void registerUser(User user){
        
        usersMapper.addUser(user);//ユーザーテーブルに追加

        //パスワードテーブルに追加
        user.setId(user.getId()); //addUserでセットしたID
        passwordMapper.addPassword(user);
    }

    @Override
    public boolean canUserLogin(User user){
        //ユーザーネームからID、パスワードを取得
        Integer userId = usersMapper.selectByName(user.getUserName());
        if(userId == null){
            return false;
        }

        String password = passwordMapper.selectById(userId);
        if(password == null || password.isEmpty()){
            return false;
        }

        //DBから取得したパスワードと入力フォームのパスワードを比較
        if(password.equals(user.getUserPassword())){
            // ログイン成功時にユーザーIDをUserオブジェクトにセット
            user.setId(userId); // この行を追加
            return true;
        }
        return false;
    }
}
