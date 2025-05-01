package school.faang.triwizardtournament;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Student {
    private final String name;
    private final int year;

    @Getter(AccessLevel.NONE)
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
