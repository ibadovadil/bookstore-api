package com.adil.bookstore.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterResponse {
    private String username;
    private String email;
    private String role;
    private String token;
    private String message;
}
