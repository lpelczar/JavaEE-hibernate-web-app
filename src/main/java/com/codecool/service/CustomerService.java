package com.codecool.service;

import com.codecool.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();
    void addCustomer(Customer customer);
    void deleteCustomer(int id);
    Customer getCustomerById(int id);
}
