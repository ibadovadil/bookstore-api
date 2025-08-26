package com.adil.bookstore.service.interf;

import com.adil.bookstore.dto.user.UserChangePasswordDto;
import com.adil.bookstore.dto.user.UserDetailDto;
import com.adil.bookstore.dto.user.UserUpdateDto;

public interface IUserService {
    UserDetailDto getUserDetails();

    UserDetailDto updateUser(UserUpdateDto dto);

    void changePassword(UserChangePasswordDto dto);

    void deleteUser();
}
