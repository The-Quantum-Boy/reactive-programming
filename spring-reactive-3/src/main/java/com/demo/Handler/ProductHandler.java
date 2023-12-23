package com.demo.Handler;


import com.demo.model.Product;
import com.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class ProductHandler {

    @Autowired
    private ProductService productService;



    public Mono<ServerResponse> getAll(ServerRequest req){
        return ok().contentType(MediaType.TEXT_EVENT_STREAM).body(productService.getAll(),Product.class);
    }
}
