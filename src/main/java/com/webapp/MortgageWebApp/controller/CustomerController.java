package com.webapp.MortgageWebApp.controller;

import com.webapp.MortgageWebApp.entities.Customer;
import com.webapp.MortgageWebApp.repositories.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    CustomerRepository customerRepository = new CustomerRepository();

    @RequestMapping("/customers")
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerRepository.getCustomerList());
        return "customersView";
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer") Customer customer, BindingResult result) {
        if(!result.hasErrors()) {
            customerRepository.addCustomer(customer);
            System.out.println("Successfully inserted new customer");
        } else {
            System.out.println("Error inserting new customer");
        }
        return "customersView";
    }

    @GetMapping("/addCustomerView")
    public String redirectAddNew() {
        return "addCustomerView";
    }
}
