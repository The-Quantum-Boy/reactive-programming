package com.sumit.service;

import com.sumit.entity.Product;
import com.sumit.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Flux<Product> getAllProducts(){
        return this.repository.findAll();
    }

    public Mono<Product> getProductById(int productId){
        return this.repository.findById(productId);
    }

    public Mono<Product> createProduct(Product product){
        return this.repository.save(product);
    }

    public Mono<Product> updateProduct(int productId,Mono<Product> productMono){
        return this.repository
                .findById(productId)
                .flatMap(p->
                        productMono.map(u->{
                            p.setDescription(u.getDescription());
                            p.setPrice(u.getPrice());
                            return p;
                        }))
                .flatMap(p->this.repository.save(p));
    }


    public Mono<Void> deleteProduct(int id){
        return this.repository.deleteById(id);
    }
}
