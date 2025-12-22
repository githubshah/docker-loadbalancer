package com.my.uber;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UberConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
