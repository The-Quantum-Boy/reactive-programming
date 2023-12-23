package com.demo.config;

import com.demo.Handler.ProductHandler;
import com.demo.model.Product;
import com.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Configuration
public class RoutesConfig {

    @Autowired
    private  ProductService productService;


    @Bean
    public RouterFunction<ServerResponse> router(ProductHandler productHandler){
        return route()
//                .GET("/products",
//                         req->ok().contentType(MediaType.TEXT_EVENT_STREAM)
//                                 .body(productService.getProduct(), Product.class))
                .GET("/products", productHandler::getProducts)
                .build();
    }


}
