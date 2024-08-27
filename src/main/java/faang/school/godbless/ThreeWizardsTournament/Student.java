package faang.school.godbless.ThreeWizardsTournament;

import lombok.Getter;

@Getter
public class Student {
    private String name;
    private int year;
    private int points;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
        points = 0;
    }

    public synchronized void setPoints(int points) {
        this.points = points;
    }
}
