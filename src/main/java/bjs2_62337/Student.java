package bjs2_62337;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

public class Student {
    @Getter
    private final String name;
    @Getter
    private final int year;
    private final AtomicInteger points = new AtomicInteger();

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public int getPoints() {
        return points.get();
    }

    public void addPoints(int pointsToAdd) {
        points.addAndGet(pointsToAdd);
    }
}
