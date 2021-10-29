package com.example.ASWS;

import com.example.ASWS.models.*;
import com.example.ASWS.repositories.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean @Order
  CommandLineRunner initDatabase(CustomerRepository repository, ContactRepository repository2) {

    return args -> {
      Contact c = new Contact(1L, "Lucifer", 630450028989L, "kh784@uowmail.edu.au", "CEO");
      log.info("Preloading " + repository2.save(c));
      log.info("Preloading " + repository.save(new Customer(1L, "Nasa", "33 Evergreen NSW 3088", "Australia",c)));

      Contact c2 = new Contact(2L, "Steve", 230450028989L, "ah784@uowmail.edu.au", "CEO");
      log.info("Preloading " + repository2.save(c2));
      log.info("Preloading " + repository.save(new Customer(2L, "FBI", "33 Evergreen NSW 3088", "Australia",c2)));

      Contact c3 = new Contact(3L, "Sam", 330450028989L, "bh784@uowmail.edu.au", "CEO");
      log.info("Preloading " + repository2.save(c3));
      log.info("Preloading " + repository.save(new Customer(3L, "CIA", "33 Evergreen NSW 3088", "Australia",c3)));

      Contact c4 = new Contact(4L, "Kevin", 430450028989L, "ch784@uowmail.edu.au", "CEO");
      log.info("Preloading " + repository2.save(c4));
      log.info("Preloading " + repository.save(new Customer(4L, "TSA", "33 Evergreen NSW 3088", "Australia",c4)));

      Contact c5 = new Contact(5L, "John", 530450028989L, "dh784@uowmail.edu.au", "CEO");
      log.info("Preloading " + repository2.save(c5));
      log.info("Preloading " + repository.save(new Customer(5L, "NSA", "33 Evergreen NSW 3088", "Australia",c5)));

    };
  } 

}