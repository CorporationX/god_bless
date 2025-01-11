package school.faang.sprint_4.task_51696;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@ToString
@Getter
@AllArgsConstructor
public class Student {
    private String nameOfStudent;
    private int year;
    private AtomicInteger points;

    public void addPoints(int points) {
        this.points.addAndGet(points);
    }

    public int getPoints() {
        return points.get();
    }
}
