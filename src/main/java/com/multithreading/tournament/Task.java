package com.multithreading.tournament;

import lombok.Getter;

import java.util.Random;


public class Task {
    private final Random random = new Random();
    @Getter
    private final String name;
    @Getter
    private final int difficulty;
    private int reward;

    public Task(String name, int difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    public int getReward() {
        reward = random.nextInt(10);
        return reward;
    }
}
