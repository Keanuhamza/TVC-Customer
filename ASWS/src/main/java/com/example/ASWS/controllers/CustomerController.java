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
  private final ContactRepository contactRepository;

  CustomerController(CustomerRepository repository, ContactRepository contactrepo) {
    this.repository = repository;
    this.contactRepository = contactrepo;
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
  Customer one(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
  }

  @PutMapping("/customer/{id}")
  Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {

    return repository.findById(id)
      .map(customer -> {
        customer.setCompanyName(newCustomer.getCompanyName());
        customer.setAddress(newCustomer.getAddress());
        customer.setCountry(newCustomer.getCountry());
        return repository.save(customer);
      })
      .orElseGet(() -> {
        newCustomer.setId(id);
        return repository.save(newCustomer);
      });
  }

  @PutMapping("/customer/{id}/contact/{contactid}")
  Customer updateCustomerContact(@PathVariable Long id, @PathVariable Long contactid) {
    Customer customer = repository.findById(id).orElseThrow(RuntimeException::new);
    Contact contact = contactRepository.findById(contactid).orElseThrow(RuntimeException::new);
    customer.setContact(contact);
    return repository.save(customer);
  }

  @DeleteMapping("/customer/{id}")
  void deleteCustomer(@PathVariable("id") Long id) {
    repository.deleteById(id);
  }
}
