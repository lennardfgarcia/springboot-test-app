package com.example.demo.bootstrap;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.domain.Publisher;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Lennard for the Spring Boot 3 training course
 */

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
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

        // Persist the information to the respective DBs
        Author miekSaved = authorRepository.save(miek);
        Book hyggeSaved = bookRepository.save(hygge);

        // Create another author & book
        Author west = new Author();
        west.setFirstName("Tracey");
        west.setLastName("West");

        Book dm = new Book();
        dm.setTitle("Dragon Masters");
        dm.setIsbn("9876543321");

        // Persist the information to the respective DBs
        Author westSaved = authorRepository.save(west);
        Book dmSaved = bookRepository.save(dm);

        // Associate the books with the authors
        hyggeSaved.getAuthors().add(miekSaved);
        dmSaved.getAuthors().add(westSaved);

        // Also do this for the inverse side
        miekSaved.getBooks().add(hyggeSaved);
        westSaved.getBooks().add(dmSaved);

        // create a new publisher object
        Publisher happy = new Publisher();
        happy.setPublisherName("Happy Publisher");
        happy.setZipCode("12345");
        Publisher happySaved = publisherRepository.save(happy);

        // assign this publisher to both books for simplicity
        hyggeSaved.setPublisher(happySaved);
        dmSaved.setPublisher(happySaved);

        // Persist everything to the DBs
        authorRepository.save(miekSaved);
        authorRepository.save(westSaved);
        bookRepository.save(hyggeSaved);
        bookRepository.save(dmSaved);

        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
