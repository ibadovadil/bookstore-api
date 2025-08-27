package com.adil.bookstore.mapper;


import com.adil.bookstore.dto.author.*;
import com.adil.bookstore.entity.Author;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {BookMapper.class})
public interface AuthorMapper {

    // Author → AuthorListDto
    AuthorListDto toListDto(Author author);

    // Author → AuthorDetailDto
    @Mapping(source = "books", target = "books") // BookListDto mapping üçün BookMapper istifadə olunur
    AuthorDetailDto toDetailDto(Author author);

    // AuthorCreateDto → Author
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "books", ignore = true)
    Author toEntity(AuthorCreateDto dto);

    // AuthorUpdateDto → mövcud Author update
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "books", ignore = true)
    void updateEntityFromDto(AuthorUpdateDto dto, @MappingTarget Author author);
}
