package com.example.demo.bootstrap;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Lennard for the Spring Boot 3 training course
 */
@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Create author & book
        Author miek = new Author();
        miek.setFirstName("Miek");
        miek.setLastName("Wiking");

        Book hygge = new Book();
        hygge.setTitle("The Little Book of Hygge");
        hygge.setIsbn("123456789");

        // Create repository
        Author miekSaved = authorRepository.save(miek);
        Book hyggeSaved = bookRepository.save(hygge);

        // Create author & book
        Author west = new Author();
        west.setFirstName("Tracey");
        west.setLastName("West");

        Book dm = new Book();
        dm.setTitle("Dragon Masters");
        dm.setIsbn("9876543321");

        // Create repository
        Author westSaved = authorRepository.save(west);
        Book dmSaved = bookRepository.save(dm);

        // Associate the books with the authors
        hyggeSaved.getAuthors().add(miekSaved);
        dmSaved.getAuthors().add(westSaved);

        // Also do this for the inverse side
        miekSaved.getBooks().add(hyggeSaved);
        westSaved.getBooks().add(dmSaved);

        bookRepository.save(hyggeSaved);
        bookRepository.save(dmSaved);


        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
    }
}
