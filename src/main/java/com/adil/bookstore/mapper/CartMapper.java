package com.adil.bookstore.mapper;

import com.adil.bookstore.dto.cart.*;
import com.adil.bookstore.entity.*;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring", uses = {BookMapper.class})
public interface CartMapper {

    // Cart → CartDetailDto
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "items", target = "items")
    CartDetailDto toDetailDto(Cart cart);

    // CartItem → CartItemDto
    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "book.title", target = "bookTitle")
    CartItemDto toItemDto(CartItem item);

    // CartItemCreateDto → CartItem (entity)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cart", ignore = true)
    @Mapping(target = "priceAtAdd", ignore = true) // service layer-də set olunacaq
    @Mapping(target = "book", ignore = true)      // service layer-də set olunacaq
    CartItem toEntity(CartItemCreateDto dto);

    // CartItemUpdateDto → CartItem (update mövcud entity)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cart", ignore = true)
    @Mapping(target = "book", ignore = true)
    @Mapping(target = "priceAtAdd", ignore = true)
    void updateEntityFromDto(CartItemUpdateDto dto, @MappingTarget CartItem item);
}
