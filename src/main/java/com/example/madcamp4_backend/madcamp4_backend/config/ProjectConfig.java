package com.example.madcamp4_backend.madcamp4_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;

@Configuration
public class ProjectConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .allowedHeaders("Authorization", "Content-Type", "Accept")
                        .exposedHeaders("Authorization")
//                        .allowCredentials(true)
                        .maxAge(3600);
            }
        };
    }

//    @Bean
//    public OncePerRequestFilter corsFilter() {
//        return new OncePerRequestFilter() {
//            @Override
//            protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain) throws jakarta.servlet.ServletException, IOException {
//                response.addHeader("Access-Control-Allow-Origin", "*");
//                response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//                response.addHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
//                response.addHeader("Access-Control-Expose-Headers", "Authorization");
//
//                if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
//                    response.setStatus(HttpServletResponse.SC_OK);
//                } else {
//                    filterChain.doFilter(request, response);
//                }
//            }
//        };
//    }
}
