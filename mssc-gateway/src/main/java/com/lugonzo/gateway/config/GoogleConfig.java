package com.lugonzo.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GoogleConf {

    @Bean
    public RouteLocator googleConfig(RouteLocatorBuilder builder){
       return builder.routes()
               .route(r->r.path("/googlesearch")
               .uri("https://google.com"))
               .build();
    }
}
