package com.example.madcamp4_backend.madcamp4_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;
import java.util.logging.Logger;

@Configuration
@EnableWebSecurity
public class ProjectConfig {

    private static final Logger logger = Logger.getLogger(ProjectConfig.class.getName());

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(c -> {
                    CorsConfigurationSource source = request -> {
                        CorsConfiguration config = new CorsConfiguration();
                        config.setAllowedOrigins(List.of("http://localhost:3000")); // 혹은 "*"로 모든 출처 허용
                        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                        config.setAllowedHeaders(List.of("*"));

                        // 콘솔 로그 찍기
                        logger.info("CORS configuration applied with allowed origins: " + config.getAllowedOrigins());

                        return config;
                    };
                    c.configurationSource(source);
                })
                .csrf(AbstractHttpConfigurer::disable)  // CSRF 비활성화
                .authorizeHttpRequests(authz -> authz.anyRequest().permitAll());  // 모든 요청 허용

        // 콘솔 로그 찍기
        logger.info("SecurityFilterChain configured.");

        return http.build();
    }
}
