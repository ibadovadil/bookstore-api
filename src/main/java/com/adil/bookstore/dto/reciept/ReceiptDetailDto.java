package com.adil.bookstore.dto.reciept;


import com.adil.bookstore.dto.order.OrderItemDto;
import lombok.*;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReceiptDetailDto {
    private Long id;
    private Long orderId;
    private String receiptNumber;
    private Instant issuedAt;
    private List<OrderItemDto> items; // hər məhsulun adı, miqdarı, qiyməti
    private short totalPrice;
}
