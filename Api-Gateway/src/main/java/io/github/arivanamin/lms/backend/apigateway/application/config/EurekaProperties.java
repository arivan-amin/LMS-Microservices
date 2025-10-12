package io.github.arivanamin.lms.backend.apigateway.application.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties (prefix = "eureka")
public record EurekaProperties(String host, String port) {

}
