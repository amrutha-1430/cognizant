package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void registerNewBook() {
        System.out.println("Registering a new book via BookService...");
        bookRepository.saveBook();
    }
}
