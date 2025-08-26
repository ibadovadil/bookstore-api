package com.adil.bookstore.service.impl;


import com.adil.bookstore.dto.user.UserChangePasswordDto;
import com.adil.bookstore.dto.user.UserDetailDto;
import com.adil.bookstore.dto.user.UserUpdateDto;
import com.adil.bookstore.entity.User;
import com.adil.bookstore.mapper.UserMapper;
import com.adil.bookstore.repo.UserRepository;
import com.adil.bookstore.service.interf.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    private static String retrieveCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @Override
    public UserDetailDto getUserDetails() {
        String username = retrieveCurrentUsername();
        User user = userRepository.findByUsernameOrEmail(username).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDetailDto(user);
    }


    @Override
    public UserDetailDto updateUser(UserUpdateDto dto) {
        User user = userRepository.findByUsernameOrEmail(retrieveCurrentUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (dto.getUsername() != null && !dto.getUsername().equals(user.getUsername())) {
            if (userRepository.existsByUsername(dto.getUsername())) {
                throw new RuntimeException("Username is already taken!");
            }
            user.setUsername(dto.getUsername());
        }
        if (dto.getEmail() != null && !dto.getEmail().equals(user.getEmail())) {
            if (userRepository.existsByEmail(dto.getEmail())) {
                throw new RuntimeException("Email is already in use!");
            }
            user.setEmail(dto.getEmail());
        }
        userMapper.updateUserFromDto(dto, user);

        User updatedUser = userRepository.save(user);
        return userMapper.toDetailDto(updatedUser);
    }

    @Override
    public void changePassword(UserChangePasswordDto dto) {
        User user = userRepository.findByUsernameOrEmail(retrieveCurrentUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!passwordEncoder.matches(dto.getOldPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Old password is not correct");
        }
        if (passwordEncoder.matches(dto.getNewPassword(), user.getPassword())) {
            throw new IllegalArgumentException("New password cannot be the same as old password");
        }
        if (passwordEncoder.matches(dto.getNewPassword(), user.getUsername())) {
            throw new IllegalArgumentException("New password cannot be the same as username");
        }
        if (passwordEncoder.matches(dto.getNewPassword(), user.getEmail())) {
            throw new IllegalArgumentException("New password cannot be the same as email");
        }
        user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        userRepository.save(user);
    }

    @Override
    public void deleteUser() {
        User user = userRepository.findByUsernameOrEmail(retrieveCurrentUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }


}
