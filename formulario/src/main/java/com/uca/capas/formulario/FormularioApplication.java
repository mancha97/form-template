package com.uca.capas.formulario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages= {"com.uca.capas"})
@SpringBootApplication
public class FormularioApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormularioApplication.class, args);
	}

}
