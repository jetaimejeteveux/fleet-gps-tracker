package com.jetaimejeteveux.gpstracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "Fleet GPS Tracking API",
        version = "1.0",
        description = "API for tracking and managing fleet vehicles GPS data"
    )
)
public class GpstrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GpstrackerApplication.class, args);
	}

}
