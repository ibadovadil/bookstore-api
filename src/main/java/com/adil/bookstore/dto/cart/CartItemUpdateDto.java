package com.adil.bookstore.dto.cart;
import lombok.*;
import jakarta.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemUpdateDto {
    @Min(1)
    private int quantity;
}
