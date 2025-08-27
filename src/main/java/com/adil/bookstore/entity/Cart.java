package com.adil.bookstore.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "carts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> items;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Instant createdAt;
}