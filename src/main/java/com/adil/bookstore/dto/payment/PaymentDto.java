package com.adil.bookstore.dto.payment;

import lombok.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto {
    private Long id;
    private Long orderId;
    private BigDecimal amount;
    private String cardNumber;
    private Instant paidAt;
}
