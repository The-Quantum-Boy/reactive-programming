package com.sumit.dao;

import com.sumit.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    private static void sleepExecution(int i){
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    public List<Customer> getCustomer(){
       return IntStream.rangeClosed(1,50)
               .peek(CustomerDao::sleepExecution)
               .peek(i-> System.out.println("Processing count "+i))
               .mapToObj(i-> new Customer(i,"Customer"+i))
               .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomerStream(){
        return Flux.range(1,50)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i-> System.out.println("processing count-> "+i))
                .map(i-> new Customer(i,"Customer"+i));
    }

    public Flux<Customer> getCustomersList(){
        return Flux.range(1,50)
                .doOnNext(i-> System.out.println("processing count-> "+i))
                .map(i-> new Customer(i,"Customer"+i))
                .delayElements(Duration.ofSeconds(2));
    }
}

