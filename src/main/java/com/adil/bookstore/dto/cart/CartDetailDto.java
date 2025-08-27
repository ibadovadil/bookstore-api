package com.adil.bookstore.dto.cart;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDetailDto {
    private Long id;
    private Long userId;
    private List<CartItemDto> items;
}
