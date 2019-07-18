package com.brandonporter.orders2.repos;

import com.brandonporter.orders2.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
