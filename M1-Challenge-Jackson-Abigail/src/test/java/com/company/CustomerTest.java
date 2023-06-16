package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    Customer exampleCustomer1;
    Customer exampleCustomer2;

    @BeforeEach
    void setUp() {

        //first example customer with a positive balance
        exampleCustomer1 = new Customer();
        List<AccountRecord> customerRecords;

        exampleCustomer1.setId(4);
        exampleCustomer1.setName("Quarry Inc");


        //total = 35
        for(int i = -10; i<=20; i+=5) {
            //create an account record for each charge
            //-10, -5, 0, 5, 10, 15, 20
            AccountRecord accountRecord = new AccountRecord();
            accountRecord.setCharge(i);

            //add each record to the customer's charges
            customerRecords = exampleCustomer1.getCharges();
            customerRecords.add(accountRecord);
        }

        //second example customer with a negative balance
        exampleCustomer2 = new Customer();

        exampleCustomer2.setId(5);
        exampleCustomer2.setName("Berry Farms");

        //total = -55
        for(int i = -30; i<=20; i+=5) {
            //create an account record for each charge
            //-30, -25, -20, -15, -10, -5, 0, 5, 10, 15, 20
            AccountRecord accountRecord = new AccountRecord();
            accountRecord.setCharge(i);

            //add each record to the customer's charges
            customerRecords = exampleCustomer2.getCharges();
            customerRecords.add(accountRecord);
        }
    }

    @Test
    void getBalance() {
        assertEquals(35, exampleCustomer1.getBalance());
        assertEquals(-55, exampleCustomer2.getBalance());
    }

    @Test
    void testToString() {
        assertEquals("4 - Quarry Inc: 35", exampleCustomer1.toString());
        assertEquals("5 - Berry Farms: -55", exampleCustomer2.toString());
    }
}