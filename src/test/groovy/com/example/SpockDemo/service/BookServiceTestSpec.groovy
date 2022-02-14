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

        book.setId(1L)
        book.setTitle("Dummy 1")
        book.setAuthor("Dummy 2")
    }

    def "GetBooks should return all books"() {
        when:
        bookService.getBooks()

        then:
        1 * bookRepository.findAll()
    }

    def "AddBook should add a book to the repository"() {
        when:
        bookService.addBook(book)

        then:
        1 * bookRepository.findByTitle(_) >> new ArrayList<Book>()
        1 * bookRepository.save(book)

    }

    def "DeleteBook should delete book by ID"() {
        given:
        bookRepository.existsById(_) >> true

        when:
        bookService.deleteBook(book.getId())

        then:
        1 * bookRepository.deleteById(book.getId())
    }

    def "UpdateBook should update book"() {
        given:
        Book bookTest = new Book()
        bookTest.setId(1L)
        bookTest.setTitle("Hello")
        bookTest.setAuthor("Trump")
        bookRepository.findById(_) >> Optional.of(bookTest)

        when:
        bookService.updateBook(book.getId(), book.getTitle(), book.getAuthor())

        then:
        1 * bookRepository.save(_)


    }

}
