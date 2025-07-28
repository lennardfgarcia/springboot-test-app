package com.example.demo.services;

import com.example.demo.domain.Author;
import com.example.demo.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Lennard for the Spring Boot 3 training course
 */

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}
