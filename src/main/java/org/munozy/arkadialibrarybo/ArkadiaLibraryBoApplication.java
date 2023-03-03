package org.munozy.arkadialibrarybo;

import org.munozy.arkadialibrarybo.client.ArkadiaLibraryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class ArkadiaLibraryBoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArkadiaLibraryBoApplication.class, args);
	}

	@Bean
	ArkadiaLibraryClient client(WebClient.Builder builder) {
		return HttpServiceProxyFactory
				.builder(WebClientAdapter.forClient(builder.baseUrl("http://localhost:8080/arkadia-library/api/v1").build()))
				.build()
				.createClient(ArkadiaLibraryClient.class);
	}

}
