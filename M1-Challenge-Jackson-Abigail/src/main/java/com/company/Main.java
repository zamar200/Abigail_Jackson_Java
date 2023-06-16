package com.company;

import java.util.*;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );


    public static void main(String[] args) {


        //create a list of customers
        List<Customer> customerList = new ArrayList<>();

        //create a list of account records
        List<AccountRecord> customerRecords;


        //for each customer within the static data
        for (String[] customerArray:customerData) {

            boolean customerExists = false;

            //parse through the static customer data
            int id = Integer.parseInt(customerArray[0]);
            int charge = Integer.parseInt(customerArray[2]);
            String date = customerArray[3];

            //create the account record associated with the account
            AccountRecord accountRecord = new AccountRecord();
            accountRecord.setCharge(charge);
            accountRecord.setChargeDate(date);

            //determine if the customer exists
            for(Customer customer: customerList) {
                if (Objects.equals(customer.getId(), id)) {
                    customerExists = true;

                    //if the customer exists then add the charge to the customer's charges
                    customerRecords = customer.getCharges();
                    customerRecords.add(accountRecord);
                    break;
                }
            }

            //if the customer does not exist then,
            if (!customerExists) {

                //create a new customer object
                Customer customer = new Customer();
                String customerName = customerArray[1];

                //set the customer's specifications
                customer.setId(id);
                customer.setName(customerName);
                customerList.add(customer);

                // add the charge to the customer's charges
                customerRecords = customer.getCharges();
                customerRecords.add(accountRecord);
            }

        }

        //print all customer's information
        for(Customer customer: customerList) {
            System.out.println(customer);
            System.out.println("Charges:");
            for(AccountRecord record: customer.getCharges()) {
                System.out.println(record.getCharge());
            }
            System.out.println();
        }

        //print the accounts with a positive balance
        System.out.println("Positive accounts:");
        for(Customer customer: customerList) {
            if (customer.getBalance() > 0) {
                System.out.println(customer);
            }
        }
        System.out.println();

        //print the accounts with a negative balance
        System.out.println("Negative accounts:");
        for(Customer customer: customerList) {
            if (customer.getBalance() < 0) {
                System.out.println(customer);
            }
        }
    }
}
