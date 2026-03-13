package com.lpu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lpu.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}