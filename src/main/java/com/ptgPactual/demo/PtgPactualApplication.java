package com.ptgPactual.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PtgPactualApplication {

	public static void main(String[] args) {
		SpringApplication.run(PtgPactualApplication.class, args);
	}

}
