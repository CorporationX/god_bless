package school.faang.task_51119;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@ToString
public class Student {
    private String name;
    private int year;
    private int points;

    public Student(String name, int year, int points) {
        if (name.isEmpty()) {
            log.error("Field name cannot be empty");
        }
        this.name = name;
        this.year = year;
        this.points = points;
    }

    public void addPoints(int points) {
        this.points += points;
    }
}
