package com.sumit.handler;

import com.sumit.dao.CustomerDao;
import com.sumit.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {

    @Autowired
    private CustomerDao dao;

    public Mono<ServerResponse> loadCustomer(ServerRequest request){
        Flux<Customer> customerList= dao.getCustomersList();
        return ServerResponse.ok().body(customerList,Customer.class);
    }

    public Mono<ServerResponse> findCustomer(ServerRequest request){
        int customerId= Integer.valueOf(request.pathVariable("input"));
//        Mono<Customer> customerStream = dao.getCustomersList().filter(c->c.getId()==customerId).take(1).single();
        Mono<Customer> customerMono = dao.getCustomersList().filter(c->c.getId()==customerId).next();

        return ServerResponse.ok()
                .body(customerMono,Customer.class);
    }

    public Mono<ServerResponse> saveCustomer(ServerRequest request){
        Mono<Customer> customerMono = request.bodyToMono(Customer.class);
        Mono<String> saveRes = customerMono.map(dto -> dto.getId() + ":" + dto.getName());
        return ServerResponse.ok().body(saveRes,String.class);
    }
}
