package com.webapp.MortgageWebApp.services;

import com.webapp.MortgageWebApp.entities.Customer;

import java.util.ArrayList;

public interface CustomerService {
    ArrayList<Customer> getCustomerList();
    ArrayList<String> getAttributeList();
    void addCustomer(Customer customer);
}
