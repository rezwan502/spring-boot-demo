package com.example.springcore.common;

public class BaseballCoach implements Coach{
    @Override
    public String dailyWorkout() {
        return "Spend 30 minutes in batting practice!";
    }
}
