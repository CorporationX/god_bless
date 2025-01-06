package ru.maks1979.task_50182;

import lombok.Data;

@Data
public class Quest {
    private String name;
    private int difficulty;
    private int reward;

    public Quest(String name, int difficulty, int reward) {
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }
}/
