package com.lpu.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.lpu.entity.Book;
import com.lpu.repository.BookRepository;
import com.lpu.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repo;

    public BookServiceImpl(BookRepository repo) {
        this.repo = repo;
    }

    public Book save(Book b) {
        return repo.save(b);
    }

    public List<Book> getAll() {
        return repo.findAll();
    }

    public Book get(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}