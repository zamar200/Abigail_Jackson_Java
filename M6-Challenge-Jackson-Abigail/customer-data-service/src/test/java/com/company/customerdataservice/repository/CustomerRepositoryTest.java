package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository repo;

    @BeforeEach
    public void setup() throws Exception {
        repo.deleteAll();
    }

    @Test
    public void createCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Liam");
        customer.setLastName("Walker");
        customer.setEmail("liam.walker@example.com");
        customer.setCompany( "PQR Co.");
        customer.setPhone("888-999-1111");
        customer.setAddress1("777 Oak St");
        customer.setAddress2("Suite 8A");
        customer.setCity("Chicago");
        customer.setState("IL");
        customer.setPostalCode("60604");
        customer.setCountry("USA");

        customer = repo.save(customer);

        Optional<Customer> customer1 = repo.findById(customer.getId());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void getAlLCustomers() {

        Customer customer1 = new Customer();
        customer1.setFirstName("Noah");
        customer1.setLastName("Garcia");
        customer1.setEmail("noah.garcia@example.com");
        customer1.setCompany("LMN Solutions");
        customer1.setPhone("222-333-4444");
        customer1.setAddress1("789 Pine St");
        customer1.setCity("Houston");
        customer1.setState("TX");
        customer1.setPostalCode("77002");
        customer1.setCountry("USA");
        repo.save(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstName("Ava");
        customer2.setLastName("Lee");
        customer2.setEmail("ava.lee@example.com");
        customer2.setCompany("MNO Corp.");
        customer2.setPhone("666-777-8888");
        customer2.setAddress1("1010 Maple Ave");
        customer2.setCity("Miami");
        customer2.setState("FL");
        customer2.setPostalCode("33101");
        customer2.setCountry("USA");
       repo.save(customer2);


        List<Customer> customerList = repo.findAll();

        assertEquals(2, customerList.size());
    }

    @Test
    public void updateCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Jane");
        customer.setLastName("Smith");
        customer.setEmail("jane.smith@example.com");
        customer.setCompany("XYZ Enterprises");
        customer.setPhone("555-987-6543");
        customer.setAddress1("456 Oak St");
        customer.setCity("New York");
        customer.setState("NY");
        customer.setPostalCode("10002");
        customer.setCountry("USA");

        repo.save(customer);

        customer.setFirstName("UPDATED");

        repo.save(customer);

        Optional<Customer> customer1 = repo.findById(customer.getId());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void deleteCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Michael");
        customer.setLastName("Johnson");
        customer.setEmail("michael.johnson@example.com");
        customer.setCompany("LMN Corp.");
        customer.setPhone("555-222-3333");
        customer.setAddress1("789 Elm St");
        customer.setCity("Houston");
        customer.setState("TX");
        customer.setPostalCode("77001");
        customer.setCountry("USA");

        repo.save(customer);

        repo.deleteById(customer.getId());

        Optional<Customer> customer1 = repo.findById(customer.getId());

        assertTrue(customer1.isEmpty());
    }

    @Test
    public void getCustomerById() {
        Customer customer1 = new Customer();
        customer1.setFirstName("Grace");
        customer1.setLastName("Perez");
        customer1.setEmail("grace.perez@example.com");
        customer1.setCompany("ABC Inc.");
        customer1.setPhone("222-444-6666");
        customer1.setAddress1("555 Maple Ave");
        customer1.setAddress2("Apt 1C");
        customer1.setCity("Houston");
        customer1.setState("TX");
        customer1.setPostalCode("77004");
        customer1.setCountry("USA");

        repo.save(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstName("Lucas");
        customer2.setLastName("Turner");
        customer2.setEmail("lucas.turner@example.com");
        customer2.setCompany("XYZ Corp.");
        customer2.setPhone("444-666-8888");
        customer2.setAddress1("333 Elm Rd");
        customer2.setAddress2("Suite 2");
        customer2.setCity("San Francisco");
        customer2.setState("CA");
        customer2.setPostalCode("94104");
        customer2.setCountry("USA");

        repo.save(customer2);

        Optional <Customer> customer = repo.findById(customer1.getId());

        assertEquals(customer.get(), customer1);
    }

    @Test
    public void getCustomerByState() {

        Customer customer1 = new Customer();
        customer1.setFirstName("James");
        customer1.setLastName("Miller");
        customer1.setEmail("james.miller@example.com");
        customer1.setCompany("XYZ Corp.");
        customer1.setPhone("111-222-3333");
        customer1.setAddress1("222 Oak St");
        customer1.setAddress2("Suite 5A");
        customer1.setCity("Los Angeles");
        customer1.setState("CA");
        customer1.setPostalCode("90002");
        customer1.setCountry("USA");

        repo.save(customer1);

        Customer customer2 = new Customer();;
        customer2.setFirstName("Benjamin");
        customer2.setLastName("Taylor");
        customer2.setEmail("benjamin.taylor@example.com");
        customer2.setCompany("ABC Inc.");
        customer2.setPhone("999-888-7777");
        customer2.setAddress1("777 Maple Ave");
        customer2.setAddress2("Apt 3B");
        customer2.setCity("Houston");
        customer2.setState("TX");
        customer2.setPostalCode("77002");
        customer2.setCountry("USA");

        repo.save(customer2);

        Customer customer3 = new Customer();
        customer3.setFirstName("Charlotte");
        customer3.setLastName("Lewis");
        customer3.setEmail("charlotte.lewis@example.com");
        customer3.setCompany("LMN Ltd.");
        customer3.setPhone("333-555-7777");
        customer3.setAddress1("666 Birch Ln");
        customer3.setAddress2("");
        customer3.setCity("New York");
        customer3.setState("NY");
        customer3.setPostalCode("10004");
        customer3.setCountry("USA");

        repo.save(customer3);

        List <Customer> customerList = repo.findByState("CA");

        assertEquals(1, customerList.size());
        assertEquals(customer1, customerList.get(0));
    }
}
