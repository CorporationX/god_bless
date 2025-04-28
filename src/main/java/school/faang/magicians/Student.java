package school.faang.magicians;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Student {
    private final String name;
    private int studyYear;
    private AtomicInteger points;

    public Student(String name, int studyYear, int points) {
        this.name = name;
        this.studyYear = studyYear;
        this.points = new AtomicInteger(points);
    }

    public void addPoints(int points) {
        this.points.addAndGet(points);
    }
}
