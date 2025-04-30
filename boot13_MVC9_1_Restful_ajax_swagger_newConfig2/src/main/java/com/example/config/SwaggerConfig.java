package com.example.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;



@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI openAPI() {
		Info info = new Info()
				.version("v1.0")
				.title("호텔예약 API")
				.description("영화 커뮤니티 프로젝트 API");
		return new OpenAPI()
					.info(info);
	}
}
