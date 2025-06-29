package school.faang.module1.bjs2_82756;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Student {
    private final String name;
    private final int year;
    private final AtomicInteger points = new AtomicInteger(0);

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public void addPoints(int amount) {
        points.addAndGet(amount);
    }

    public int getPoints() {
        return points.get();
    }
}