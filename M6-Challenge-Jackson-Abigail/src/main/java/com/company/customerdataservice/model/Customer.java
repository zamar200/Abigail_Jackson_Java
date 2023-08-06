package com.company.customerdataservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;
    private String company;
    private String phone;
    private String address1;
    private String address2;
    private String city;
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    private String country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(email, customer.email) && Objects.equals(company, customer.company) && Objects.equals(phone, customer.phone) && Objects.equals(address1, customer.address1) && Objects.equals(address2, customer.address2) && Objects.equals(city, customer.city) && Objects.equals(state, customer.state) && Objects.equals(postalCode, customer.postalCode) && Objects.equals(country, customer.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, company, phone, address1, address2, city, state, postalCode, country);
    }
}
