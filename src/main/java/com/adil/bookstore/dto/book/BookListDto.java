package com.adil.bookstore.dto.book;

import java.math.BigDecimal;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookListDto {
    private Long id;
    private String title;
    private String author;
    private BigDecimal price;
    private double rating;
}
