package com.example.ASWS.controllers;

import java.util.List;

import com.example.ASWS.models.*;
import com.example.ASWS.repositories.*;
import com.example.ASWS.exceptions.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

  private final CustomerRepository repository;

  CustomerController(CustomerRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/customers")
  List<Customer> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/customer")
  Customer newContact(@RequestBody Customer newCustomer) {
    return repository.save(newCustomer);
  }

  // Single item
  
  @GetMapping("/customer/{id}")
  Customer one(@PathVariable String id) {
    
    return repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
  }

  @PutMapping("/customer/{id}")
  Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable String id) {
    
    return repository.findById(id)
      .map(customer -> {
        customer.setCompanyName(newCustomer.getCompanyName());
        customer.setAddress(newCustomer.getAddress());
        customer.setCountry(newCustomer.getCountry());
        return repository.save(newCustomer);
      })
      .orElseGet(() -> {
        newCustomer.setCompanyName(newCustomer.getCompanyName());
        return repository.save(newCustomer);
      });
  }

  @DeleteMapping("/customr/{id}")
  void deleteCustomer(@PathVariable String id) {
    repository.deleteById(id);
  }
}
