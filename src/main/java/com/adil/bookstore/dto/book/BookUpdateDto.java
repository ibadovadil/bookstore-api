package com.adil.bookstore.dto.book;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookUpdateDto {
    private String title;
    private String description;
    private double price;
    private short stock;
    private Long authorId;
}