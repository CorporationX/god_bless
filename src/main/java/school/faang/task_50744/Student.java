package school.faang.task_50744;

import lombok.Getter;
import school.faang.exception.CheckException;

@Getter
public class Student {
    private final String name;
    private final int year;
    private int points;

    public Student(String name, int year, int points) {
        if (name == null || name.isEmpty()) {
            throw new CheckException("studentName");
        }
        this.name = name;
        this.year = year;
        this.points = points;
    }

    public void addPoints(int points) {
        System.out.printf("%s добавлено %s очков%n", this.name, points);
        this.points += points;
    }
}
