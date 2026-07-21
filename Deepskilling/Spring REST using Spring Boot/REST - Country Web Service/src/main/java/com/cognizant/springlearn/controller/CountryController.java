package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public Country getCountryIndia() {
        // Loads the XML config and initializes the beans context
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        // Fetches the bean managed by the Spring IoC container
        Country country = context.getBean("country", Country.class);

        return country;
    }
}
