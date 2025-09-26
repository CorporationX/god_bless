package school.faang.future_completable_future.bjs2_2906;

import java.util.concurrent.atomic.AtomicInteger;

public class Student {
    private final String name;
    private final int year;
    private final AtomicInteger points = new AtomicInteger(0);

    public Student(String name,
                   int year,
                   int points) {
        this.name = name;
        this.year = year;
        addPoints(points);
    }

    public int getPoints() {
        return points.get();
    }

    public void addPoints(int points) {
        this.points.addAndGet(points);
    }
}