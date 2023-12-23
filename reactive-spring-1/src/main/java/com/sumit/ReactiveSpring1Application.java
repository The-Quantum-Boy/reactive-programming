package com.sumit;

import com.sumit.models.Product;
import com.sumit.repositories.ProductRepository;
import com.sumit.services.ProductSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;
import reactor.core.publisher.Mono;

@EnableWebFlux
@SpringBootApplication
public class ReactiveSpring1Application implements CommandLineRunner {

	@Autowired
	private ProductSerivce service;

	public static void main(String[] args) {
		SpringApplication.run(ReactiveSpring1Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Product product=new Product(1,"amit");
//		this.service.createProduct(product)
//				.doOnNext(s-> System.out.println("product created "+s))
//				.subscribe();
		this.service.findById(1)
				.doOnNext(System.out::println)
				.subscribe();
	}
}
