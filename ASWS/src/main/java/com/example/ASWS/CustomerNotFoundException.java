package com.example.ASWS;

public class CustomerNotFoundException extends RuntimeException {

    CustomerNotFoundException(String id) {
      super("Could not find customer " + id);
    }
  }
