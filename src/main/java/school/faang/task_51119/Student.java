package school.faang.task_51119;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@ToString
public class Student {
    private final String name;
    private final int year;
    private int points;

    public Student(String name, int year, int points) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Field name cannot be empty");
        }
        this.name = name;
        this.year = year;
        this.points = points;
    }

    public void addPoints(int points) {
        this.points += points;
    }
}
