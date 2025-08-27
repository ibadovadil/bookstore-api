package com.adil.bookstore.mapper;

import com.adil.bookstore.dto.order.*;
import com.adil.bookstore.entity.Order;
import com.adil.bookstore.entity.OrderItem;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring", uses = {BookMapper.class})
public interface OrderMapper {

    // Order → OrderDetailDto
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "items", target = "items")
    OrderDetailDto toDetailDto(Order order);

    // OrderItem → OrderItemDto
    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "book.title", target = "bookTitle")
    OrderItemDto toItemDto(OrderItem item);

    // OrderCreateDto → Order (entity)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true) // service layer-də set olunur
    @Mapping(target = "createdAt", ignore = true) // JPA Auditing və ya service layer
    @Mapping(target = "items", ignore = true) // service layer-də cart item-lardan map ediləcək
    @Mapping(target = "user", ignore = true) // service layer-də set olunacaq
    Order toEntity(OrderCreateDto dto);

    // OrderItemCreateDto → OrderItem (entity)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "order", ignore = true)
    @Mapping(target = "book", ignore = true) // service layer-də set olunacaq
    @Mapping(target = "price", ignore = true) // service layer-də set olunacaq
    OrderItem toEntity(OrderItemCreateDto dto);
}
