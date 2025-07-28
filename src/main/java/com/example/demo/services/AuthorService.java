package com.example.demo.services;

import com.example.demo.domain.Author;

/**
 * Created by Lennard for the Spring Boot 3 training course
 */

public interface AuthorService {

    Iterable<Author> findAll();

}
