package com.sumit.service;

import com.sumit.dao.CustomerDao;
import com.sumit.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao dao;

    public List<Customer> loadAllCustomer(){
        long start=System.currentTimeMillis();
        List<Customer> customers=dao.getCustomer();
        long end=System.currentTimeMillis();
        System.out.println("Total execution time "+(end-start));
        return customers;
    }

    public Flux<Customer> loadAllCustomerStream(){
        long start=System.currentTimeMillis();
        Flux<Customer> customers=dao.getCustomerStream();
        long end=System.currentTimeMillis();
        System.out.println("Total execution time "+(end-start));
        return customers;
    }

}
