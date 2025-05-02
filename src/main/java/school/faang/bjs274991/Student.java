package school.faang.bjs274991;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private final String name;
    private final int year;
    private int points;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
        this.points = 0;
    }

    public synchronized void setPoints(int pts) {
        this.points = pts;
    }
}
