package school.faang.bjs274891;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    private int points;

    public synchronized void addPoints(int points) {
        this.points += points;
    }

    public synchronized int getPoints() {
        return points;
    }
}
