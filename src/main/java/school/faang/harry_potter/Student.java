package school.faang.harry_potter;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Student {
    private final String name;
    private final int year;
    private final AtomicInteger points;

    public Student(String name, int year, int points) {
        this.name = name;
        this.year = year;
        this.points = new AtomicInteger(points);
    }

    public void addPoints(int pointsToAdd) {
        if (pointsToAdd < 0) {
            throw new IllegalArgumentException("Ќельз€ добавить отрицательное количество очков");
        }
        points.addAndGet(pointsToAdd);
    }

    public int getPoints() {
        return points.get();
    }
}
