package com.adil.bookstore.mapper;


import com.adil.bookstore.dto.payment.PaymentCreateDto;
import com.adil.bookstore.dto.payment.PaymentDto;
import com.adil.bookstore.entity.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    // Payment → PaymentDto
    @Mapping(source = "order.id", target = "orderId")
    PaymentDto toDto(Payment payment);

    // PaymentCreateDto → Payment entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "paidAt", ignore = true) // service layer-də set olunacaq
    @Mapping(target = "order", ignore = true)  // service layer-də set olunacaq
    Payment toEntity(PaymentCreateDto dto);
}
