package com.adil.bookstore.service.impl;

import com.adil.bookstore.dto.admin.UserListDto;
import com.adil.bookstore.entity.User;
import com.adil.bookstore.enums.Role;
import com.adil.bookstore.mapper.UserMapper;
import com.adil.bookstore.repo.UserRepository;
import com.adil.bookstore.service.interf.IAdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminService implements IAdminService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserListDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toUserListDto(users);
    }

    @Override
    public UserListDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toListDto(user);
    }

    @Override
    public UserListDto updateUserRole(Long userId, String role) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Role newRole = mapRole(role);
        user.setRole(newRole);
        User updatedUser = userRepository.save(user);

        return userMapper.toListDto(updatedUser);
    }

    private Role mapRole(String role) {
        switch (role.toLowerCase()) {
            case "admin":
                return Role.ROLE_ADMIN;
            case "user":
                return Role.ROLE_USER;
            case "author":
                return Role.ROLE_AUTHOR;
            default:
                throw new RuntimeException("Invalid role: " + role);
        }
    }
    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }
}
