package com.example.ASWS;

import org.springframework.data.jpa.repository.JpaRepository;

interface ContactRepository extends JpaRepository<Contact, Long> {

}