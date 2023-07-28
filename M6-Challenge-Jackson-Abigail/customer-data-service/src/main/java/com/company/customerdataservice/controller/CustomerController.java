package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository repo;

    @PostMapping("/customer")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer) {
        return repo.save(customer);
    }

    @GetMapping("/customers")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    @PutMapping("/customer")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer) {
        repo.save(customer);
    }

    @DeleteMapping("/customer/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Integer customerId) {
        repo.deleteById(customerId);
    }

    @GetMapping("/customer/{customerId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Customer getCustomerById(@PathVariable Integer customerId) {
        Optional<Customer> returnVal = repo.findById(customerId);
        return returnVal.isPresent() ? returnVal.get() : null;
    }

    @GetMapping("/customer/state/{state}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Customer> getCustomerByState(@PathVariable String state) {
        return repo.findByState(state);
    }
}
