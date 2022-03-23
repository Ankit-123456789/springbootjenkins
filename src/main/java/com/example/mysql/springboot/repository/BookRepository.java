package com.example.mysql.springboot.repository;

import com.example.mysql.springboot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    public List<Book> findByBookName(String bookName);
}
