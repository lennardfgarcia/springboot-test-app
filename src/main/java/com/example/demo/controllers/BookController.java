package com.example.demo.controllers;

import com.example.demo.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Lennard for the Spring Boot 3 training course
 */

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {
            model.addAttribute("books", bookService.findAll());

            return "books";
    }
}
