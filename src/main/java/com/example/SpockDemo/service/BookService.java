package com.example.SpockDemo.service;

import com.example.SpockDemo.controller.Book;
import com.example.SpockDemo.persistence.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;


@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {

        List<Book> bookByTitle = bookRepository.findByTitle(book.getTitle());

        if(!bookByTitle.isEmpty()){
            throw new IllegalStateException("Title Already Exists");
        }
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {

        boolean idExist = bookRepository.existsById(id);
        if(!idExist) {
            throw new IllegalStateException("The book with id " + id + " does not exist");
        }
        bookRepository.deleteById(id);
    }

    public void updateBook(Long id, String title, String author) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("The book with id " + id + " does not exist"));

        if (title != null && title.length() > 0 && !Objects.equals(book.getTitle(), title)){
            book.setTitle(title);
        }

        if (author != null && author.length() > 0 && !Objects.equals(book.getAuthor(), author)){
            book.setAuthor(author);
        }

        bookRepository.save(book);

    }
}
