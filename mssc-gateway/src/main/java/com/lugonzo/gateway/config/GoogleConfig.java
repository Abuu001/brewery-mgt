package com.lugonzo.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class GoogleConfig {

    @Bean
    public RouteLocator googleConf(RouteLocatorBuilder builder){
       return builder.routes()
               .route(r->r.path("/googlesearch")
               .uri("https://scholar.google.com/"))
               .build();
    }
}
