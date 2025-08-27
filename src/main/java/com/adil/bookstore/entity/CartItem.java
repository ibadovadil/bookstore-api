package com.adil.bookstore.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    private short priceAtAdd;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Instant createdAt;
}
