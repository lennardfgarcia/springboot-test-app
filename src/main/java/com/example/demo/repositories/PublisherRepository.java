package com.example.demo.repositories;

import com.example.demo.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Lennard
 */

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
