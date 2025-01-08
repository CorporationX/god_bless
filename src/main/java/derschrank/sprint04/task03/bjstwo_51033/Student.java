package derschrank.sprint04.task03.bjstwo_51033;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private final String name;
    private int year;
    private int points;

    public synchronized void addPoints(int delta) {
        points += delta;
    }

    @Override
    public String toString() {
        return name + " (" + year + "year), has points: " + points;
    }
}
