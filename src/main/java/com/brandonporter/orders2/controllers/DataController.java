package com.brandonporter.orders2.controllers;

import com.brandonporter.orders2.models.Customer;
import com.brandonporter.orders2.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/data/customer")
public class DataController {

    @Autowired
    CustomerService custserv;

    @PostMapping(value="/new",
                produces = {"application/json"},
                consumes = {"application/json"})
    public ResponseEntity<?> saveCust(@Valid @RequestBody Customer newCustomer){
        newCustomer=custserv.save(newCustomer);

        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{custid}")
    public ResponseEntity<?> deleteCustomer(@PathVariable long custid){
        custserv.deleteCustomer(custid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/update/{custid}",
                consumes = {"application/json"})
    public ResponseEntity<?> updateCustomer(@PathVariable long custid, @Valid @RequestBody Customer cust){
        custserv.update(cust,custid);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
