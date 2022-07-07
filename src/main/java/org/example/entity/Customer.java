package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name="client")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String city;
    private String country;
    @Column(name="company-name")
    private String companyName;
    private String firstName;
    private String lastName;
    private String phone;
    private int state;

    public Customer(){};

    public Customer(String prenom){
        this.firstName=prenom;
    }
    public Customer(Long id, String address, String city, String country, String companyName, String firstName, String lastName, String phone, int state) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.country = country;
        this.companyName = companyName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
