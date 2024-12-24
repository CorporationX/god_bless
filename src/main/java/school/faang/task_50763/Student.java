package school.faang.task_50763;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
    private final String name;
    private final int year;
    private int points;

    public synchronized void addPoints(int pointsToAdd) {
        this.points += pointsToAdd;
    }
}