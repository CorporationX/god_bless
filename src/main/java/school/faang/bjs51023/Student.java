package school.faang.bjs51023;

import lombok.Getter;

public class Student {
    private String name;
    private int year;
    @Getter
    private int points;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public void increasePoints(int points) {
        this.points += points;
    }
}
