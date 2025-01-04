package school.faang.task_50931;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class Student {
    private final String name;
    private int year;
    private AtomicInteger points;

    public Student(String name, int year, int points) {
        this.name = name;
        this.year = year;
        this.points = new AtomicInteger(points);
    }

    public void addPoints(int value) {
        points.getAndAdd(value);
    }

    public int getPoints() {
        return points.get();
    }
}
