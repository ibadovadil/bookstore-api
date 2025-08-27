package com.adil.bookstore.dto.payment;

import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentCreateDto {
    @NotNull
    private Long orderId;

    @NotBlank
    private String cardNumber;

    @NotNull
    private BigDecimal amount;
}
