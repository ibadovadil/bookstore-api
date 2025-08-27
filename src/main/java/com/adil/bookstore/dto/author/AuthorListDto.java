package com.adil.bookstore.dto.author;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorListDto {
    private Long id;
    private String name;
}