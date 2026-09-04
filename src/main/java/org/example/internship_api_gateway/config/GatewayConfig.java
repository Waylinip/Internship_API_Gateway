package org.example.internship_api_gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Value("${services.auth.url}")
    private String authServiceUrl;

    @Value("${services.user.url}")
    private String userServiceUrl;

    @Value("${services.order.url}")
    private String orderServiceUrl;

    @Value("${services.payment.url}")
    private String paymentServiceUrl;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()

                .route("auth-service", r -> r
                        .path("/api/auth/**")
                        .uri(authServiceUrl))
                .route("user-service", r -> r
                        .path("/api/users/**")
                        .uri(userServiceUrl))
                .route("user-service", r -> r
                        .path("/api/cards/**")
                        .uri(userServiceUrl))
                .route("order-service", r -> r
                        .path("/api/orders/**")
                        .uri(orderServiceUrl))
                .route("item-service", r -> r
                        .path("/api/items/**")
                        .uri(orderServiceUrl))
                .route("payment-service", r -> r
                        .path("/api/payments/**")
                        .uri(paymentServiceUrl))
                .build();
    }
}
