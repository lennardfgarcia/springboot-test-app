package com.example.demo.services;

import com.example.demo.domain.Book;

/**
 * Created by Lennard for the Spring Boot 3 training course
 */

public interface BookService {

    Iterable<Book> findAll();

}
