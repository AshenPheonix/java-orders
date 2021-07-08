package com.brandonporter.orders2.repos;

import com.brandonporter.orders2.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByName(String name);
}
