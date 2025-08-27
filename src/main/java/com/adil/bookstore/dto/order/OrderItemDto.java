package com.adil.bookstore.dto.order;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemDto {
    private Long bookId;
    private String bookTitle;
    private int quantity;
    private short price;
}
