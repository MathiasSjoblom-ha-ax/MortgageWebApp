package com.webapp.MortgageWebApp.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    Customer customer;

    @BeforeEach
    public void reset() {
        customer = new Customer("Mathias", 5000, 4.5, 6);
    }

    @Test
    void testGetName() {
        assertEquals("Mathias", customer.getName());
    }

    @Test
    void testSetName() {
        customer.setName("Leif");
        assertEquals("Leif", customer.getName());
    }

    @Test
    void testGetTotalLoan() {
        assertEquals(5000, customer.getTotalLoan());
    }

    @Test
    void testSetTotalLoan() {
        customer.setTotalLoan(30.22);
        assertEquals(30.22, customer.getTotalLoan());
    }

    @Test
    void testGetInterest() {
        assertEquals(4.5, customer.getInterest());
    }

    @Test
    void testSetInterest() {
        customer.setInterest(100);
        assertEquals(100, customer.getInterest());
    }

    @Test
    void testGetYears() {
        assertEquals(6, customer.getYears());
    }

    @Test
    void testSetYears() {
        customer.setYears(200);
        assertEquals(200, customer.getYears());
    }

    @Test
    void testGetMonthlyPayment() {
        DecimalFormat df = new DecimalFormat("#.##");
        String expected = df.format(78.42);
        assertEquals(expected, customer.getMonthlyPayment());
    }
}
