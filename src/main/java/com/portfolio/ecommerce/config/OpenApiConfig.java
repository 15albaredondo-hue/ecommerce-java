package com.portfolio.ecommerce.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Ecommerce REST API",
                version = "1.0.0",
                description = "REST API desarrollada con Spring Boot para la gestión de usuarios, roles y futuras funcionalidades de un ecommerce.",
                contact = @Contact(
                        name = "Alba Redondo Ardid",
                        email = "todavianolopongo@gmail.com"
                ),
                license = @License(
                        name = "MIT License"
                )
        )
)
public class OpenApiConfig {
}