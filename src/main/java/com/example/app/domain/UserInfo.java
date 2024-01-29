package com.example.app.domain;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserInfo {
    @Size(min = 1, max = 30, message = "ユーザー名は1文字以上30文字以内である必要があります")
    private String userName;

    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "パスワードは半角英数字のみである必要があります")
    private String password;
}
