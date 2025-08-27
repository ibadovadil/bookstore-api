package com.adil.bookstore.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

@Entity
@Table(name = "receipts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id", unique = true)
    private Order order;

    @Column(nullable = false, unique = true)
    private String receiptNumber;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant issuedAt;}
