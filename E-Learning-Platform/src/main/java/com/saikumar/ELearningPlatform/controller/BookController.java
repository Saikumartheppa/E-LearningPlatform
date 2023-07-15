package com.saikumar.ELearningPlatform.controller;

import com.saikumar.ELearningPlatform.model.Book;
import com.saikumar.ELearningPlatform.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("book")
    public String addBook(@RequestBody Book book){
        bookService.addBook(book);
        return "book Added!!!";
    }
    @GetMapping("book/{bId}")
    public Book getBookById(@PathVariable Long bId){
        return bookService.getBookById(bId);
    }
    @GetMapping("books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @PutMapping("book")
    public String updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }
    @DeleteMapping("book/{bId}")
    public String deleteBook(@PathVariable Long bId){
        return bookService.deleteBook(bId);
    }
}
