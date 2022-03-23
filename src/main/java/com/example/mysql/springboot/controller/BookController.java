package com.example.mysql.springboot.controller;

import com.example.mysql.springboot.model.Book;
import com.example.mysql.springboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @PostMapping("/bookSave")
    public String insertBook(@RequestBody Book book){
        bookRepository.save(book);
        return  "Your record is saved ";
    }
    @PostMapping("/multipleBookSave")
    public String insertBook(@RequestBody List<Book> book){
        bookRepository.saveAll(book);
        return "Your record is saved succewssfully";
    }
    @GetMapping("/getAllBook")
    public List<Book> getBook(){
        return (List<Book>) bookRepository.findAll();
    }
    @GetMapping("/getByBookName/{name}")
    public  List<Book> getBook(@PathVariable("name") String bookName){
        return (List<Book>) bookRepository.findByBookName(bookName);
    }
    @GetMapping("/getByBookId/{bookId}")
    public Optional<Book> getBook(@PathVariable("bookId") Long id)
    {
        return bookRepository.findById(id);
    }
}
