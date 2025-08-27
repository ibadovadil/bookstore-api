package com.adil.bookstore.dto.author;

import com.adil.bookstore.dto.book.BookListDto;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDetailDto {
    private Long id;
    private String name;
    private String bio;
    private List<BookListDto> books; // Author-un kitabları
}