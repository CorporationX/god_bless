package school.faang.task_50763;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Student {
    private final String name;
    private final int year;
    private final int mastery;
    private final AtomicInteger points = new AtomicInteger();

    public Student(String name, int year, int mastery) {
        this.name = name;
        this.year = year;
        this.mastery = mastery;
    }

    public void addPoints(int pointsToAdd) {
        points.addAndGet(pointsToAdd);
    }
}