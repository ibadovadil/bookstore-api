package com.adil.bookstore.dto.order;

import lombok.*;
import java.time.Instant;
import java.util.List;
import com.adil.bookstore.enums.OrderStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailDto {
    private Long id;
    private Long userId;
    private List<OrderItemDto> items;
    private short totalPrice;
    private OrderStatus status;
    private Instant createdAt;
}
