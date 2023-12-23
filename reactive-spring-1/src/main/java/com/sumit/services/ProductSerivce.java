package com.sumit.services;

import com.sumit.models.Product;
import com.sumit.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ProductSerivce {

    private final ProductRepository productRepository;

    public ProductSerivce(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Mono<Product> createProduct(Mono<Product> product){
        return product.flatMap(productRepository::save);
    }

    public Mono<Product> findById(int id){
        return productRepository.findById(id);
    }

    public Flux<Product> getProducts() { // whole method takes 10 seconds to execute
        return productRepository.findAll() // 2 products
                .delayElements(Duration.ofSeconds(2)); // for any element add a sleep duration
    }
}
