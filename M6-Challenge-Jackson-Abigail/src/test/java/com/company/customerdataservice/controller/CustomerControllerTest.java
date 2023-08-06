package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CustomerRepository repo;

    private final ObjectMapper objectMapper = new ObjectMapper();


    @Test
    public void customerController_createCustomer_returnStatusCreated() throws Exception {

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

        String inputJson = objectMapper.writeValueAsString(customer);

        mockMvc.perform(
                        post("/customer")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void customerController_getCustomers_returnStatusOk() throws Exception {

        mockMvc.perform(
                        get("/customers")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void customerController_updateCustomer_returnStatusOk() throws Exception {

        Customer customer = new Customer();
        customer.setId(1);
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

        String inputJson = objectMapper.writeValueAsString(customer);

        mockMvc.perform(
                        put("/customer")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void customerController_deleteCustomer_returnStatus() throws Exception {

        mockMvc.perform(
                        delete("/customer/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void customerController_findCustomerById_returnStatusOk() throws Exception {

        mockMvc.perform(
                        get("/customer/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void customerController_findCustomerByState_returnStatusOk() throws Exception {

        mockMvc.perform(
                        get("/customer/state/CA"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
