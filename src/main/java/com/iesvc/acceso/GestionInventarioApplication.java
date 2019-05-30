package com.iesvc.acceso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(considerNestedRepositories = true)

public class GestionInventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionInventarioApplication.class, args);
	}

}
