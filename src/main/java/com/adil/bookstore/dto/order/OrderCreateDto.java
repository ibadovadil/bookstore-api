package com.adil.bookstore.dto.order;


import lombok.*;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderCreateDto {
    @NotNull
    private Long userId;

    @NotNull
    private List<OrderItemCreateDto> items; // checkout zamanı cart item-lardan gələcək
}
