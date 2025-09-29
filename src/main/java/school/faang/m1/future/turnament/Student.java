package school.faang.m1.future.turnament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
@Setter
public class Student {
    private final String name;
    private final int year;
    private final AtomicInteger points = new AtomicInteger(0);

    public Student(String name, int year, int points) {
        this.name = name;
        this.year = year;
        this.points.set(points);
    }

    public void addPoints(int delta) {
        points.addAndGet(delta);
    }
}
