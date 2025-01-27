package com.personalphotomap.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final String uploadDir = System.getProperty("user.dir") + "/api/images/uploads/";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/images/uploads/**")
                .addResourceLocations("file:" + uploadDir);
    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**") // Permitir todas as rotas
//                .allowedOrigins("http://localhost:8080") // Permitir apenas o front-end local
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos
//                .allowedHeaders("*") // Permitir todos os cabeçalhos
//                .allowCredentials(true); // Permitir cookies (se necessário)
//    }

}