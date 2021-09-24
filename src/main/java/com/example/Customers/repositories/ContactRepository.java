package com.example.Customers.repositories;

import com.example.Customers.models.Contact;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}