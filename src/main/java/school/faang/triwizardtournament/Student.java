package school.faang.triwizardtournament;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Student {
    private final String name;
    private final int year;
    private final AtomicInteger points;

    public Student(String name, int year, int points) {
        this.name = name;
        this.year = year;
        this.points = new AtomicInteger(points);
    }

    void gainPoints(int reward) {
        points.addAndGet(reward);
    }

    public int getPoints() {
        return points.get();
    }
}
