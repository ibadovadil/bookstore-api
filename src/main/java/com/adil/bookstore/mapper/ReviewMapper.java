package com.adil.bookstore.mapper;

import com.adil.bookstore.dto.review.*;
import com.adil.bookstore.entity.Review;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewListDto toListDto(Review review);

    ReviewDetailDto toDetailDto(Review review);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "book", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Review toEntity(ReviewCreateDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "book", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateEntityFromDto(ReviewUpdateDto dto, @MappingTarget Review review);
}
