package faang.school.godbless.bjs2_24947;

import lombok.Getter;

@Getter
public class Student {
    private String name;
    private int year;
    private int points;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public void addPoints(int points) {
        this.points += points;
    }
}
