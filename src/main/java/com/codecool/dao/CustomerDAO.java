package com.codecool.dao;

import com.codecool.model.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();
    void addCustomer(Customer customer);
    void deleteCustomer(int id);
    Customer getCustomerById(int id);
}
