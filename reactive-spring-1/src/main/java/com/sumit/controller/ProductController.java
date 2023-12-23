package com.sumit.controller;

import com.sumit.models.Product;
import com.sumit.services.ProductSerivce;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {

   final private ProductSerivce productSerivce;

    public ProductController(ProductSerivce productSerivce) {
        this.productSerivce = productSerivce;
    }

    @PostMapping("/create")
    public Mono<Product> createProduct(@RequestBody Mono<Product> product){
        return productSerivce.createProduct(product);
    }

    @GetMapping(value = "/product", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> getProduct() {
        return productSerivce.getProducts();
    }

}
