package com.adil.bookstore.dto.book;

import com.adil.bookstore.dto.review.ReviewListDto;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDetailDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private short stock;
    private double rating;
    private short reviewCount;
    private String authorName;
    private List<ReviewListDto> reviews;
}