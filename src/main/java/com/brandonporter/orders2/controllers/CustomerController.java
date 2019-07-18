package com.brandonporter.orders2.controllers;

import com.brandonporter.orders2.models.Customer;
import com.brandonporter.orders2.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService custServ;

    @GetMapping(value="/order",
                produces={"application/json"})
    public ResponseEntity<?> listCustomers(){
        List<Customer> temp=custServ.getAllByOrders();
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @GetMapping(value="/name/{custName}",
                produces = {"application/json"})
    public ResponseEntity<?> getCustomer(@PathVariable String custName){
        Customer cust=custServ.getByName(custName);
        return new ResponseEntity<>(cust,HttpStatus.OK);
    }
}
