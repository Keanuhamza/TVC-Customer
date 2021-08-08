package com.example.ASWS;

public class ContactNotFoundException extends RuntimeException {

    ContactNotFoundException(Long id) {
      super("Could not find contact " + id);
    }
  }
