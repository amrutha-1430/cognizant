package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    
    private BookRepository bookRepository;

    // Setter method for Dependency Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void executeServiceAction() {
        System.out.println("BookService: Executing service logic...");
        if (bookRepository != null) {
            bookRepository.executeRepositoryAction();
        }
    }
}
