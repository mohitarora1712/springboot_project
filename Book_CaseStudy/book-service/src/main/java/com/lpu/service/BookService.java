package com.lpu.service;

import java.util.List;
import com.lpu.entity.Book;

public interface BookService {
    Book save(Book b);
    List<Book> getAll();
    Book get(Long id);
    void delete(Long id);
}