package com.adil.bookstore.service.interf;


import com.adil.bookstore.dto.admin.UserListDto;

import java.util.List;

public interface IAdminService {
    List<UserListDto> getAllUsers();

    UserListDto getUserById(Long id);

    UserListDto updateUserRole(Long userId, String role);

    void deleteUser(Long userId);
}