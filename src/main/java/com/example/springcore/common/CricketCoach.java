package com.example.springcore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    @PostConstruct
    public void doStartStuff() {
        System.out.println("In PostConstruct = " + getClass().getName());
    }

    @PreDestroy
    public void doDestroyStuff() {
        System.out.println("In PreDestroy = " + getClass().getName());
    }

    @Override
    public String dailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
