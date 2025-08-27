package com.adil.bookstore.dto.review;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewUpdateDto {
    private int rating;
    private String comment;
}
