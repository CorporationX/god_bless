package ru.kraiush.BJS2_38556;

import lombok.Data;

@Data
public class Quest {
    private String name;
    private long difficulty;
    private int reward;

    public Quest(String name, int difficulty, int reward) {
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }
}
