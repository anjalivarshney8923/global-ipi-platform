package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.*;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // ✅ Allow credentials (JWT, cookies, headers)
        config.setAllowCredentials(true);

        // ✅ Allow your frontend domains (IMPORTANT)
        config.setAllowedOriginPatterns(Arrays.asList(
                "http://localhost:3000",
                "https://*.onrender.com"
        ));

        // ✅ Allow all headers
        config.setAllowedHeaders(Arrays.asList("*"));

        // ✅ Allow all HTTP methods
        config.setAllowedMethods(Arrays.asList(
                "GET", "POST", "PUT", "DELETE", "OPTIONS"
        ));

        // ✅ Expose headers (important for JWT)
        config.setExposedHeaders(Arrays.asList(
                "Authorization", "Content-Type"
        ));

        // ✅ Apply config to all endpoints
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}