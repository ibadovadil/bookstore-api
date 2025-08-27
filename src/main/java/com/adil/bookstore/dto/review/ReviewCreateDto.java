package com.adil.bookstore.dto.review;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewCreateDto {
    private Long bookId;
    private int rating;
    private String comment;
}
