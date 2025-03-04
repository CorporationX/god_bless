package school.faang.sprint4.task62550;

import lombok.Getter;

@Getter
public class Student {
    private final String name;
    private int year;
    private int points;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
        points = 0;
    }

    public void addPoints(int award) {
        points += award;
    }
}
