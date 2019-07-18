package com.brandonporter.orders2.services;

import com.brandonporter.orders2.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllByOrders();
    Customer getByName(String name);

    void deleteCustomer(long id);

    Customer save(Customer customer);

    Customer update(Customer customer, long id);
}
