package org.example.internship_api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()

                .route("auth-service", r -> r
                        .path("/api/auth/**")
                        .uri("http://auth-service:8081"))
                .route("user-service", r -> r
                        .path("/api/users/**")
                        .uri("http://user-service:8082"))
                .route("user-service", r -> r
                        .path("/api/cards/**")
                        .uri("http://user-service:8082"))
                .route("order-service", r -> r
                        .path("/api/orders/**")
                        .uri("http://order-service:8083"))
                .route("item-service", r -> r
                        .path("/api/items/**")
                        .uri("http://order-service:8083"))
                .build();
    }
}
