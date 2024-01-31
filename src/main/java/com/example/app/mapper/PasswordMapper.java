package com.example.app.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Password;

@Mapper
public interface PasswordMapper {
    void addPassword(Password password);
}
