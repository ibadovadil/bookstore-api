package com.adil.bookstore.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id", unique = true)
    private Order order;

    @Column(nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(name = "paid_at", nullable = false, updatable = false)
    @CreatedDate
    private Instant paidAt;
}
