package TriwizardTournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class Student {
    private String name;
    private int year;
    private int points;

    public void addedPoints(int point) {
        System.out.println(name + " get " + point);
        this.points += point;
    }
}
