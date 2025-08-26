package com.adil.bookstore.dto.auth;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private String username;
    private List<String> roles;

}