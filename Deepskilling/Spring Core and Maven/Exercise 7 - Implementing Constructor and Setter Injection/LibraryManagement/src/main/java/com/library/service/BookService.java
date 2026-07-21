package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    
    private BookRepository bookRepository;
    private String serviceName;

    // Default constructor
    public BookService() {}

    // Constructor Injection for BookRepository
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Setter Injection for serviceName (or alternative dependency/property)
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    // Setter Injection for BookRepository (if configured via setter)
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void executeServiceAction() {
        System.out.println("BookService [" + serviceName + "]: Processing request...");
        if (bookRepository != null) {
            bookRepository.executeRepositoryAction();
        }
    }
}
