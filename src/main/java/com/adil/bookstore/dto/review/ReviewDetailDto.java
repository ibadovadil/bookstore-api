package com.adil.bookstore.dto.review;

import lombok.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDetailDto {
    private Long id;
    private int rating;
    private String comment;
    private String username; // user adı
    private String userEmail; // user email
    private Long bookId; // hansı book-a aiddir
    private Instant createdAt;
}