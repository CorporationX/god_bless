package faang.school.godbless.triwizardtournament;

import lombok.Getter;

@Getter
public class Student {
    private final String name;
    private final int year;
    private int points;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
        points = 0;
    }

    public void addPoints(int points) {
        this.points += points;
    }
}