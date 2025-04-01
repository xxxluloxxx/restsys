package com.restaurant.restsys.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "https://jade-tulumba-fd348a.netlify.app",
                        "https://inspiring-custard-bd29ff.netlify.app",
                        "https://loquacious-unicorn-540f7f.netlify.app",
                        "https://melodic-mandazi-722edb.netlify.app",
                        "https://verdant-llama-74155e.netlify.app",
                        "https://keen-sprinkles-9cdff0.netlify.app",
                        "http://localhost:5173",
                        "http://localhost:8080")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .exposedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}