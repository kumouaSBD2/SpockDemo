package com.example.SpockDemo.config;

import com.example.SpockDemo.controller.Book;
import com.example.SpockDemo.persistence.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository repository) {
        return args -> {
                Book hellowWorld = new Book(
                        "Hello World",
                        "Ku Moua");

                Book theLastStyleBender = new Book(
                        "The Last Style Bender",
                        "Israel Adesanya");

                Book theNotorious = new Book(
                        "The Notorious",
                        "Connor McGregor");

                Book theCount = new Book(
                        "The Count",
                        "Michael Bisping");

                Book stocktonSlap = new Book(
                        "Stockton Slap",
                        "Nate Diaz");

            repository.saveAll(List.of(hellowWorld, theLastStyleBender, theNotorious, theCount, stocktonSlap));

        };
    }

}
