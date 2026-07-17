package com.library;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;
import com.library.repository.BookRepository;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load spring context from applicationContext.xml
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve and test beans
        BookRepository repo = (BookRepository) context.getBean("bookRepository");
        repo.getBooks();

        BookService service = (BookService) context.getBean("bookService");
        service.serviceBooks();

        // Close context
        context.close();
    }
}
