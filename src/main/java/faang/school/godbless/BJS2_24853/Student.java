package faang.school.godbless.BJS2_24853;

import lombok.Getter;

@Getter
public class Student {
    private final String name;
    private final int year;
    private int points;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public void addPoints(int points) {
        this.points += points;
    }
}
