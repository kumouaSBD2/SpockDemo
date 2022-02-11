package com.example.SpockDemo.persistence.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpockDemo.controller.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
}