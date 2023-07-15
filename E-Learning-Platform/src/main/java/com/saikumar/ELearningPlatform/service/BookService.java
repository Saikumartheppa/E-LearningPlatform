package com.saikumar.ELearningPlatform.service;

import com.saikumar.ELearningPlatform.model.Book;
import com.saikumar.ELearningPlatform.repository.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    IBookRepo bookRepo;

    public void addBook(Book book) {
        bookRepo.save(book);
    }

    public Book getBookById(Long bId) {
     return   bookRepo.findByBookId(bId);
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public String updateBook(Book book) {
        if(bookRepo.existsById(book.getBookId())){
            bookRepo.save(book);
            return "Book updated";
        }else {
            return "Invalid credentials!!!";
        }
    }

    public String deleteBook(Long bId) {
        if(bookRepo.existsById(bId)){
            bookRepo.deleteById(bId);
            return "Book Removed";
        }else {
            return "Invalid credentials!!!";
        }
    }
}
