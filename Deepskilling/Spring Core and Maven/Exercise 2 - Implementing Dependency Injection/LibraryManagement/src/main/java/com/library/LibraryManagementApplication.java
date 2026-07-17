package com.library;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load spring context from applicationContext.xml
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve and test configured Service (with injected Repository)
        BookService service = (BookService) context.getBean("bookService");
        service.serviceBooks();

        // Close context
        context.close();
    }
}
