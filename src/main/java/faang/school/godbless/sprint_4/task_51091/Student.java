package faang.school.godbless.sprint_4.task_51091;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Student {
    private String name;
    private int year;
    private AtomicInteger points;

    public Student(String name, int year, int points) {
        this.name = name;
        this.year = year;
        this.points = new AtomicInteger(points);
    }

    public void addPoints(int points) {
        this.points.set(this.points.get() + points);
    }
}
