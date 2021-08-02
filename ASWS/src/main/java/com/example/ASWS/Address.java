package com.example.ASWS;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Address {

    private @Id @GeneratedValue Long id;
    private String name;
    private int phone;
    private string email;
    private string position;

    //Constructors
    public Employee() {}

    public Employee(Long id, String name, int phone, string email, string position) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.position = position;
    }

    //Gtters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public string getEmail() {
        return email;
    }

    public string getPosition() {
        return position;
    }
    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setEmail(string email) {
        this.email = email;
    }

    public void setPosition(string position) {
        this.position = position;
    }
    //Overides
    @Override
    public java.lang.String toString() {
        return "Address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", email=" + email +
                ", position=" + position +
                '}';
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Address address = (Address) object;
        return phone == address.phone && java.util.Objects.equals(id, address.id) && java.util.Objects.equals(name, address.name) && java.util.Objects.equals(email, address.email) && java.util.Objects.equals(position, address.position);
    }
    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), id, name, phone, email, position);
    }

}