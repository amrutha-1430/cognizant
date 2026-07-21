package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    
    public static void main(String[] args) {
        // Load the Spring IoC container
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("--- Testing Constructor Injection ---");
        BookService service1 = context.getBean("bookServiceConstructor", BookService.class);
        service1.executeServiceAction();

        System.out.println("\n--- Testing Setter Injection ---");
        BookService service2 = context.getBean("bookServiceSetter", BookService.class);
        service2.executeServiceAction();
    }
}
