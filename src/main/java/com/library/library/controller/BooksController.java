package com.library.library.controller;

import com.library.library.domain.BooksDto;
import com.library.library.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class BooksController {
    private final BooksService service;

    @Autowired
    public BooksController(BooksService service) {
        this.service = service;
    }

    @GetMapping(value = "/books")
    public List<BooksDto> getBooks() {
        return service.getBooks();
    }

    @GetMapping(value = "/books/{bookId}")
    public BooksDto getBookById(@RequestParam Long bookId) {
        return service.getBookById(bookId);
    }

    @DeleteMapping(value = "/books/{bookId}")
    public void deleteBook(@RequestParam Long bookId) {
        service.deleteBook(bookId);
    }

    @PostMapping(value = "/books")
    public void createBook(@RequestBody BooksDto booksDto) {
        service.createBook(booksDto);
    }

    @PutMapping(value = "/books")
    public BooksDto updateBook(@RequestBody BooksDto booksDto) {
        return service.updateBook(booksDto);
    }
}
