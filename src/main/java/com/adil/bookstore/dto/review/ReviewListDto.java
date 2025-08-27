package com.adil.bookstore.dto.review;
import lombok.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewListDto {
    private int rating;
    private String comment;
    private String username; // review yazan user-un adı
    private Instant createdAt;
}