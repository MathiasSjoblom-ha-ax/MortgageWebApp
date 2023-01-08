package com.webapp.MortgageWebApp.repositories;

import com.webapp.MortgageWebApp.entities.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerRepositoryTest {
    CustomerRepository repository;
    ArrayList<Customer> customerList;
    ArrayList<String> attributeList;

    @BeforeEach
    public void reset() {
        repository = new CustomerRepository();
        customerList = repository.getCustomerList();
        attributeList = repository.getAttributeList();
    }

    @Test
    void testGetCustomerList() {
        customerList.add(new Customer("Mathias", 5000, 4.5, 6));
        repository.addCustomer(customerList.get(0));
        ArrayList<Customer> testList = repository.getCustomerList();
        assertEquals(customerList, testList);
    }

    @Test
    void testGetAttributeList() {
        attributeList.add("Customer");
        attributeList.add("Total loan");
        attributeList.add("Interest");
        attributeList.add("Years");
        assertEquals(attributeList, repository.getAttributeList());
    }

    @Test
    void testAddCustomer() {
        Customer customer = new Customer("Mathias", 5000, 4.5, 6);
        repository.addCustomer(customer);
        assertEquals(customer, repository.getCustomerList().get(repository.customerList.size()-1));
    }
}
