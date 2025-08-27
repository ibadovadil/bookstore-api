package com.adil.bookstore.dto.cart;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemDto {
    private Long bookId;
    private String bookTitle;
    private int quantity;
    private short priceAtAdd;
}
