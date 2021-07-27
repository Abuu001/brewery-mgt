package com.lugonzo.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalHostConfig {

    @Bean
    public RouteLocator localHostRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r->r.path("/api/v1/beer/*")
                        .uri("http://localhost:3003"))
                .route(r->r.path("/api/v1/customer/*")
                        .uri("http://localhost:3002"))
                .build();
    }
}
