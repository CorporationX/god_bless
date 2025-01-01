package school.faang.task_51899;

import lombok.Getter;

@Getter
public class Student {
    private final String name;
    private final int year;
    private int points;

    public Student(String name, int year, int points) {
        this.name = name;
        this.year = year;
        this.points = points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    @Override
    public String toString() {
        return name + " (Year: " + year + ", Points: " + points + ")";
    }

}
