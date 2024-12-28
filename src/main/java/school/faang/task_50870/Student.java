package school.faang.task_50870;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@ToString
public class Student {
    private String name;
    private int year;
    private AtomicInteger points;

    public void addPoints(int points) {
        this.points.addAndGet(points);
    }

    public int getPoints() {
        return points.get();
    }
}
