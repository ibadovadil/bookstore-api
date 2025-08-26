package com.adil.bookstore.mapper;


import com.adil.bookstore.dto.admin.UserListDto;
import com.adil.bookstore.dto.user.UserCreateDto;
import com.adil.bookstore.dto.user.UserDetailDto;
import com.adil.bookstore.dto.user.UserUpdateDto;
import com.adil.bookstore.entity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserCreateDto dto);

    UserDetailDto toDetailDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(UserUpdateDto dto, @MappingTarget User user);

    UserListDto toListDto(User user);

    List<UserListDto> toUserListDto(List<User> users);
}
