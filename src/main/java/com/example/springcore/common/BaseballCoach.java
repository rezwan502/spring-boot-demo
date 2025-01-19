package com.example.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    @Override
    public String dailyWorkout() {
        return "Spend 30 minutes in batting practice!";
    }
}
