package school.faang.bjs2_92923;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class Student {
    private final String name;
    private final int year;
    private final AtomicInteger points = new AtomicInteger();

    public void addPoints(int addedPoints) {
        points.addAndGet(addedPoints);
    }

    public int getPoints() {
        return points.get();
    }
 }