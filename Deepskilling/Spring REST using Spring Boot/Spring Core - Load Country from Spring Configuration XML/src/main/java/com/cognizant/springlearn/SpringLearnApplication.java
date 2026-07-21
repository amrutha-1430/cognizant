package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        displayCountry();
    }

    public static void displayCountry() {
        // Loads the XML config and initializes beans
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        // Fetches the bean managed by the Spring IoC container
        Country country = context.getBean("country", Country.class);

        // Logs country details
        LOGGER.debug("Country : {}", country.toString());
    }
}
