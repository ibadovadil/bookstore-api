package com.adil.bookstore.dto.admin;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserListDto {
    private Long id;
    private String username;
    private String email;
    private String role;
}
