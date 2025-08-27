package com.adil.bookstore.dto.cart;


import lombok.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemCreateDto {
    @NotNull
    private Long bookId;

    @Min(1)
    private int quantity;
}
