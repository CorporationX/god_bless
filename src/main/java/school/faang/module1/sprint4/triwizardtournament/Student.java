package school.faang.module1.sprint4.triwizardtournament;

import lombok.Data;

@Data
public class Student {
    private final String name;
    private final int year;
    private int points;

    public Student(String name, int year, int points) {
        this.name = name;
        this.year = year;
        this.points = points;
    }

    public void addPoints(int reward) {
        points += reward;
    }
}