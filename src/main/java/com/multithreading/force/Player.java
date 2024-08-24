package com.multithreading.force;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Player {
    private String name;
    private int score;
    private int lives;

    public Player(String name, int lives) {
        if (name.isEmpty() && name.isBlank() && lives < 0) {
            throw new IllegalArgumentException("Not is valid");
        }
        this.name = name;
        this.lives = lives;
    }
}
