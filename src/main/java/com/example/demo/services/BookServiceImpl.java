package com.example.demo.services;

import com.example.demo.domain.Book;
import com.example.demo.repositories.BookRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Lennard for the Spring Boot 3 training course
 */

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
