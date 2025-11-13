package com.centroacademicoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@OpenAPIDefinition(
		 info = @Info(
		 title = "API de Clientes",
		 version = "1.0",
		 description = "Exemplo de documentação com Swagger OpenAPI"
		 )
		)

@SpringBootApplication
public class ListaApiExercicio2Application {

	public static void main(String[] args) {
		SpringApplication.run(ListaApiExercicio2Application.class, args);
	}

}
