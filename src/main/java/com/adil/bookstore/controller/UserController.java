package com.adil.bookstore.controller;


import com.adil.bookstore.dto.user.UserChangePasswordDto;
import com.adil.bookstore.dto.user.UserDetailDto;
import com.adil.bookstore.dto.user.UserUpdateDto;
import com.adil.bookstore.service.impl.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<UserDetailDto> getUserDetails() {
        UserDetailDto dto = userService.getUserDetails();
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/me/update")
    public ResponseEntity<UserDetailDto> updateUser(@Valid @RequestBody UserUpdateDto dto) {
        UserDetailDto updatedUser = userService.updateUser(dto);
        return ResponseEntity.ok(updatedUser);
    }

    @PutMapping("/me/change-password")
    public ResponseEntity<String> changePassword(@RequestBody UserChangePasswordDto dto) {
        userService.changePassword(dto);
        return ResponseEntity.ok("Password updated successfully");
    }

    @DeleteMapping("/me/delete")
    public ResponseEntity<Void> deleteUser() {
        userService.deleteUser();
        return ResponseEntity.noContent().build();
    }
}
