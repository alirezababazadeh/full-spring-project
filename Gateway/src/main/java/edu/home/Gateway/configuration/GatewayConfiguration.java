package edu.home.Gateway.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Autowired
    AuthenticationFilter filter;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/student/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://student-service")
                )
                .route(r -> r.path("/course/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://course-service")
                )
                .route(r -> r.path("/authentication/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://authentication-service")
                )
                .route(r -> r.path("/user/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://user-service")
                )
                .build();
    }
}
