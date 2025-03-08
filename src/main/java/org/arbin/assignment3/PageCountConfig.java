package org.arbin.assignment3;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PageCountConfig {
    @Bean
    public PageCounter pageCounter() {
        return new PageCounter();
    }
}