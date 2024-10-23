package ru.kraiush.BJS2_38556;

import lombok.Data;

@Data
public class Player {
    private String name;
    private int level;
    private int experience;

    public Player(String name) {
        this.name = name;
        this.level = 1;
        this.experience = 0;
    }

    public void addExperience(int experiencePoints) {
        experience += experiencePoints;
    }
}
