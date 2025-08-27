package com.adil.bookstore.mapper;

import com.adil.bookstore.dto.book.*;
import com.adil.bookstore.entity.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {ReviewMapper.class})
public interface BookMapper {

    // Book → BookListDto
    BookListDto toListDto(Book book);

    // Book → BookDetailDto
    @Mapping(source = "author", target = "authorName")
    @Mapping(source = "reviews", target = "reviews")
    BookDetailDto toDetailDto(Book book);

    // BookCreateDto → Book
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "rating", ignore = true)
    @Mapping(target = "reviewCount", ignore = true)
    @Mapping(target = "author", ignore = true)
    Book toEntity(BookCreateDto dto);

    // BookUpdateDto → Book entity update
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "rating", ignore = true)
    @Mapping(target = "reviewCount", ignore = true)
    @Mapping(target = "author", ignore = true)
    void updateEntityFromDto(BookUpdateDto dto, @MappingTarget Book book);

    // Custom mapping method: Author → String
    default String map(Author author) {
        return author != null ? author.getName() : null;
    }
}
