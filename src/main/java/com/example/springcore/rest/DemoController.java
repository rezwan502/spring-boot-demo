package com.example.springcore.rest;

import com.example.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach coach;

    @Autowired
    public DemoController(@Qualifier("baseBallCoach") Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/")
    public String getDailyWorkout() {
        return coach.dailyWorkout();
    }
}
