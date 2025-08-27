package com.adil.bookstore.entity;

import com.adil.bookstore.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    private short totalPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Instant createdAt;}
