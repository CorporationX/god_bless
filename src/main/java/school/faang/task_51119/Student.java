package school.faang.task_51119;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
@ToString
public class Student {
    private final String name;
    private final int year;
    private volatile int points;

    public Student(String name, int year, int points) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Field name cannot be empty");
        }
        this.name = name;
        this.year = year;
        this.points = points;
    }

    public synchronized void addPoints(int points) {
        this.points += points;
    }
}
