package com.sumit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {


	public void testMono() {
		Mono<?> monoString=Mono.just("sumit")
				.then(Mono.error(new RuntimeException("Exception occured")))
				.log();
		
		monoString.subscribe(System.out::println,(e)-> System.out.println(e.getMessage()));
		
		
	}
	
	
	public void fluxTest() {
		Flux<String> fluxString=Flux.just("sumit","amit","santosh")
				.concatWithValues("the hero")
				.concatWith(Flux.error(new RuntimeException("Exception occured")))
				.concatWithValues("hydra")
				.log();
		
		fluxString.subscribe(System.out::println);
	}

}
