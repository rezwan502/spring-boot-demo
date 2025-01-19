package com.example.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String dailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
