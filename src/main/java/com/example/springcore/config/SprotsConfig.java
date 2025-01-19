package com.example.springcore.config;

import com.example.springcore.common.BaseballCoach;
import com.example.springcore.common.Coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SprotsConfig {

    @Bean
    public Coach baseBallCoach() {
        return new BaseballCoach();
    }
}
