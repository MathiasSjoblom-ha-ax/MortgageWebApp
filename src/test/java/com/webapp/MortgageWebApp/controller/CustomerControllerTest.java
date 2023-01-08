package com.webapp.MortgageWebApp.controller;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.webapp.MortgageWebApp.entities.Customer;
import com.webapp.MortgageWebApp.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public class CustomerControllerTest {
    @Mock
    CustomerRepository customerRepository;
    @Mock
    Model model;
    @Mock
    BindingResult bindingResult;

    @InjectMocks
    CustomerController customerController;

    @BeforeEach
    public void reset() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Mathias", 300, 4, 10));
        customers.add(new Customer("Matti", 500, 5, 15));
        when(customerRepository.getCustomerList()).thenReturn((ArrayList<Customer>) customers);

        String view = customerController.getCustomers(model);
        assertEquals("customersView", view);

        verify(customerRepository).getCustomerList();
        verify(model).addAttribute("customers", customers);
    }

    @Test
    void testRedirectAddNew() {
        String view = customerController.redirectAddNew();
        assertEquals("addCustomerView", view);
    }

    @Test
    void testAddCustomer() {
        Customer customer = new Customer("Mathias", 5000, 4.5, 6);
        when(bindingResult.hasErrors()).thenReturn(false);

        String view = customerController.addCustomer(customer, bindingResult);
        verify(customerRepository).addCustomer(customer);
        assertEquals("customersView", view);
    }
}
