package com.demo.services;

import com.demo.Proxy.ProductProxy;
import com.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@Service
public class ProductService {

    @Autowired
    private ProductProxy proxy;

    public Flux<Product> getAll(){
        return proxy.getAll();
    }


}
