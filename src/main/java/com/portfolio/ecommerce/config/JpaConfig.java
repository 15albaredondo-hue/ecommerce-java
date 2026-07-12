package com.portfolio.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaConfig {
}
//le dice a Spring:Gestiona automáticamente los campos de auditoría de mis entidades.//