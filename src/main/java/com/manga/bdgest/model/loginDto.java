package com.manga.bdgest.model;

import lombok.Data;

@Data
public class loginDto {
    private String usernameOrEmail;
    private String password;
}
