package com.example.demo.repositories;

import com.example.demo.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Lennard for the Spring Boot 3 training course
 */

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
