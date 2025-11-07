package com.example.springdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public GreetingFormatter greetingFormatter() {
        return new GreetingFormatter();
    }

    @Bean
    public GreetingService greetingService() {
        return new GreetingServiceImpl(greetingFormatter());
    }
}
