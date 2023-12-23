package com.sumit.controller;

import com.sumit.dto.Customer;
import com.sumit.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/")
    public List<Customer> getAllCustomers(){
        return service.loadAllCustomer();
    }

    @GetMapping(value = "/stream")
    public Flux<Customer> getAllCustomersStream(){
        return service.loadAllCustomerStream();
    }
}
