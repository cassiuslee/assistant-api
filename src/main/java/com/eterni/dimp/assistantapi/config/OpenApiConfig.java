package com.eterni.dimp.assistantapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cqkir
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI assistantApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Assistant API")
                        .description("assistant-api 接口文档")
                        .version("1.0"));
    }
}