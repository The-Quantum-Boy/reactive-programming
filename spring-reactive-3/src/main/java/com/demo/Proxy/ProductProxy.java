package com.demo.Proxy;

import com.demo.exceptions.ProductRetryException;
import com.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import reactor.core.publisher.Flux;

@Component
public class ProductProxy {

    @Autowired
    private WebClient webClient;


    public Flux<Product> getAll(){

        var p= new Product();
        p.setName("default");

        return webClient
                .get()
                .uri("/products")
                .exchangeToFlux(res->res.bodyToFlux(Product.class))
//                .onErrorResume(e->Flux.just(p));
//                .onErrorResume(WebClientRequestException.class,e->Flux.just(p)) based on type of exception
//                .onErrorResume(e-> e.getMessage()==null,e->Flux.just(p)) //based on if null
//                .onErrorReturn(p)
//                .onErrorReturn(WebClientRequestException.class,p)
//                .onErrorReturn(e-> e.getMessage()==null,p);
//                .onErrorMap(e-> new ProductRetryException());
//                .doOnNext(n->{
//                    if(n.getName()==null) throw new RuntimeException();
//                })
//                .onErrorContinue((e,o)-> System.out.println(e.getMessage()));
                .onErrorContinue(RuntimeException.class,(e,o)-> System.out.println(e.getMessage()))
                .onErrorContinue(e->e.getMessage()==null,(e,o)-> System.out.println(e.getMessage()))
                .retry(2);
    }
}
