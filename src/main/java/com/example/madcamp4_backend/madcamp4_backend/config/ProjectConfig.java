package com.example.madcamp4_backend.madcamp4_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;
import java.util.logging.Logger;

@Configuration
@EnableWebSecurity
public class ProjectConfig {

    private static final Logger logger = Logger.getLogger(ProjectConfig.class.getName());

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        // 아래의 origin은 실제 출처로 변경해야 합니다
        config.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
        config.setAllowedMethods(Collections.singletonList("*"));  // 모든 HTTP 메서드 허용
        config.setAllowedHeaders(Collections.singletonList("*"));  // 모든 헤더 허용
        source.registerCorsConfiguration("/**", config);

        http
                .cors(cors -> cors.configurationSource(source))  // CORS 설정 적용
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
