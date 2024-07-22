package com.example.madcamp4_backend.madcamp4_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;

import java.util.List;
import java.util.logging.Logger;

@Configuration
@EnableWebSecurity
public class ProjectConfig {

    private static final Logger logger = Logger.getLogger(ProjectConfig.class.getName());

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // CORS 설정
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(List.of("*")); // 모든 출처 허용
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        corsConfiguration.setAllowedHeaders(List.of("*"));
        corsConfiguration.addExposedHeader("Authorization");
        source.registerCorsConfiguration("/**", corsConfiguration);

        http
                .cors(cors -> cors.configurationSource(source))
                .csrf(AbstractHttpConfigurer::disable)  // CSRF 비활성화
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()  // Preflight 요청 허용
                        .anyRequest().permitAll())  // 모든 요청 허용
                .exceptionHandling(exceptions -> exceptions
                        .accessDeniedPage("/403"));  // 권한 거부 페이지 설정

        // 콘솔 로그 찍기
        logger.info("SecurityFilterChain configured with CORS and CSRF settings.");

        return http.build();
    }
}
