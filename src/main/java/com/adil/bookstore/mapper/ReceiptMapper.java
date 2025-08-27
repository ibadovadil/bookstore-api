package com.adil.bookstore.mapper;

import com.adil.bookstore.dto.reciept.ReceiptDetailDto;
import com.adil.bookstore.dto.reciept.ReceiptDto;
import com.adil.bookstore.entity.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {OrderMapper.class})
public interface ReceiptMapper {

    // Receipt → ReceiptDto
    @Mapping(source = "order.id", target = "orderId")
    ReceiptDto toDto(Receipt receipt);


    // Receipt → ReceiptDetailDto
    @Mapping(source = "order.id", target = "orderId")
    @Mapping(source = "order.items", target = "items")  // OrderItem-ları map edirik
    @Mapping(source = "order.totalPrice", target = "totalPrice")
    ReceiptDetailDto toDetailDto(Receipt receipt);
}
