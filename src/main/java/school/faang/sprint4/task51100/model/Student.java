package school.faang.sprint4.task51100.model;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Slf4j
@ToString
public class Student {
    private final String name;
    private final int year;
    private final AtomicInteger points = new AtomicInteger(0);

    public void addPoint(int points) {
        this.points.addAndGet(points);
    }

    public int getPoints() {
        return this.points.get();
    }
}
