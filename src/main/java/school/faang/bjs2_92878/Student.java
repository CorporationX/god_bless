package school.faang.bjs2_92878;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
public class Student {
    private final String name;
    private int year;
    private AtomicInteger points;

    public void increasePoints(int points) {
        int currentPointsValue = this.points.intValue();
        this.points.set(currentPointsValue + points);
    }
}
