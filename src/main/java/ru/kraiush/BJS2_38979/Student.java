package ru.kraiush.BJS2_38979;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    private int points;

    public void getReward(int reward) {
        points += reward;
    }
}
