package com.adil.bookstore.repo;

import com.adil.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
