package com.klu.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.klu.model.Book;

@RestController
public class LibraryController {

    List<Book> bookList = new ArrayList<>();


    // Task 2: /welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System";
    }


    // Task 3: /count
    @GetMapping("/count")
    public int count() {
        return 100;
    }


    // Task 4: /price
    @GetMapping("/price")
    public double price() {
        return 499.99;
    }


    // Task 5: /books
    @GetMapping("/books")
    public List<String> books() {

        List<String> titles = new ArrayList<>();

        titles.add("Java Programming");
        titles.add("Spring Boot Guide");
        titles.add("Data Structures");

        return titles;
    }


    // Task 6: /books/{id}
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {

        return "Book details for ID: " + id;
    }


    // Task 7: /search?title=
    @GetMapping("/search")
    public String search(@RequestParam String title) {

        return "Searching book with title: " + title;
    }


    // Task 8: /author/{name}
    @GetMapping("/author/{name}")
    public String author(@PathVariable String name) {

        return "Books written by: " + name;
    }


    // Task 9: POST /addbook
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {

        bookList.add(book);

        return "Book Added Successfully";
    }


    // Task 10: /viewbooks
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {

        return bookList;
    }

}