package com.example.app.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.app.mapper.PasswordMapper;
import com.example.app.mapper.UsersMapper;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private PasswordMapper passwordMapper;

    @Test
    public void testUserIdAndPassword(){
        //検索するユーザー名
        String userName = "test8";

        //ID検索
        Integer userId = usersMapper.selectByName(userName);
        assertNotNull(userId, "null : DBに存在しません");
        System.out.println("result : " + userId);

        //パスワード検索
        String password = passwordMapper.selectById(userId);
        assertNotNull(password, "パスワードがnull : DBに存在しません");
        System.out.println("result : " + password);

        //検証
        assertTrue(password.length() > 0, "password is null");
    }
}
