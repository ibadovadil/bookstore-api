package com.adil.bookstore.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(length = 1000)
    private String description;

    private BigDecimal price;

    private short stock;

    private double rating = 0.0;

    private short reviewCount = 0;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Instant createdAt;
}
