package com.example.SpockDemo.service

import com.example.SpockDemo.controller.Book
import com.example.SpockDemo.persistence.repository.BookRepository
import spock.lang.Specification

class BookServiceTestSpec extends Specification {

    BookRepository bookRepository = Mock(BookRepository)
    Book book
    BookService bookService

    def setup() {
        bookService = new BookService(bookRepository)
        book = new Book()
    }

    def "GetBooks should return all books"() {
        when:
        bookRepository.findAll()

        then:
        1 * bookRepository.findAll()
    }

    def "AddBook should add a book to the repository"() {
        when:
        bookRepository.save(book)

        then:
        1 * bookRepository.save(book)
    }

    def "DeleteBook should delete book by ID"() {
        when:
        bookRepository.deleteById(1)

        then:
        1 * bookRepository.deleteById(1)
    }

}
