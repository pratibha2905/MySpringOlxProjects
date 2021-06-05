package com.Olxlogin;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class OlxLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxLoginApplication.class, args);
	}
	@Bean
	public Docket getCustomizedDocket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo())
				.select()
				//.paths(PathSelectors.ant("/mymarketplace/*"))
				.apis(RequestHandlerSelectors.basePackage("com.Olxlogin"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo("Login Rest API Documentation By Pratibha",
				"Made By Pratibha",
				"1.0.0","http://zensar.com",
				new Contact("Pratibha Pandey", "www.google.com", "pratibha.pandey@zensar.com"),
				"my Springboot page",
				"http://localhost9000/mymarketplace",
				new ArrayList<VendorExtension>());
	}

}
