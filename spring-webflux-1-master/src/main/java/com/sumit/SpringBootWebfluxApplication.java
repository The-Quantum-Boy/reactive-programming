package com.sumit;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebfluxApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebfluxApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		MonoFluxTest obj=new MonoFluxTest();
//		obj.testMono();
//		obj.fluxTest();
	}

}
