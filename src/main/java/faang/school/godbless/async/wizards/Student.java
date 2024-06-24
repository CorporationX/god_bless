package faang.school.godbless.async.wizards;

import lombok.Getter;

@Getter
public class Student {
    private String name;
    private int year;
    private int points;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
        this.points = 0;
    }

    public synchronized void addPointsThreadSafe(int points) {
        this.points += points;
    }
}
