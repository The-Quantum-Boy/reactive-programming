package com.demo.services;

import com.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ProductService {




    public Flux<Product> getProduct(){

        var p1=new Product();
        p1.setName("chocolate");

        var p2=new Product();
        p2.setName("Mobile");

        var p3=new Product();
        p3.setName("pc");

        var p4=new Product();
//        p4.setName("sumit");

        return Flux.fromStream(Stream.of(p1,p2,p3,p4))
                .delayElements(Duration.ofSeconds(5));
    }
}
