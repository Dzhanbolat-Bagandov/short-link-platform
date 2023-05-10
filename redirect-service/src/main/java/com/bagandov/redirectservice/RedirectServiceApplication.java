package com.bagandov.redirectservice;

import com.bagandov.redirectservice.service.ShortLinkServiceErrorHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import java.time.Duration;

@SpringBootApplication
public class RedirectServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedirectServiceApplication.class, args);
	}

	@Bean("slsRestTemplate")
	public RestTemplate shortLinkServiceRestTemplate(
			@Value("${remote.short-link-service.address}") String shortLinkServiceAddress,
			RestTemplateBuilder restTemplateBuilder,
			ShortLinkServiceErrorHandler errorHandler
	) {
		System.out.println(shortLinkServiceAddress);

		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(new ObjectMapper());

		return restTemplateBuilder
				.rootUri(shortLinkServiceAddress)
				.messageConverters(converter)
				.errorHandler(errorHandler)
				.setConnectTimeout(Duration.ofSeconds(10))
				.setReadTimeout(Duration.ofSeconds(10))
				.build();
	}

}
