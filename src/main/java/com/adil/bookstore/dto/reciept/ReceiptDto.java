package com.adil.bookstore.dto.reciept;

import lombok.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReceiptDto {
    private Long id;
    private Long orderId;
    private String receiptNumber;
    private Instant issuedAt;
}

