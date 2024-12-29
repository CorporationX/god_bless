package school.faang.task_51062;


import lombok.NonNull;

import java.util.concurrent.atomic.AtomicInteger;

public class Student {
    private final String name;
    private final int year;
    private final AtomicInteger points;

    public Student(@NonNull String name, int year, int points) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        this.name = name;
        this.year = year;
        this.points = new AtomicInteger(points);
    }

    public void addPoints(int points) {
        this.points.addAndGet(points);
    }

    public int getPoints() {
        return points.get();
    }
}
