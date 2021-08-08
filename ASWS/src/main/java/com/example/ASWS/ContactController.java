package com.example.ASWS;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ContactController {

  private final ContactRepository repository;

  ContactController(ContactRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/contacts")
  List<Contact> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/contact")
  Contact newContact(@RequestBody Contact newContact) {
    return repository.save(newContact);
  }

  // Single item
  
  @GetMapping("/contact/{id}")
  Contact one(@PathVariable Long id) {
    
    return repository.findById(id).orElseThrow(() -> new ContactNotFoundException(id));
  }

  @PutMapping("/contact/{id}")
  Contact replaceContact(@RequestBody Contact newContact, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(contact -> {
        contact.setName(newContact.getName());
        contact.setPosition(newContact.getPosition());
        return repository.save(newContact);
      })
      .orElseGet(() -> {
        newContact.setId(id);
        return repository.save(newContact);
      });
  }

  @DeleteMapping("/contact/{id}")
  void deleteContact(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
