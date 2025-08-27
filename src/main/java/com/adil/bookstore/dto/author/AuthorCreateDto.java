package com.adil.bookstore.dto.author;

import lombok.*;
import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorCreateDto {
    @NotBlank
    private String name;

    private String bio;
}