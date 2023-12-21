package io.github.jvictor12.apialunosposgraduate.infraestrutura.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Students API - Pos Graduate")
                        .description("Students api, developmented for studies with: Java, " +
                                "spring boot, spring security, jpa, lombok, swagger, etc.")
                );
    }
}
