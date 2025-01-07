package school.faang.task_50939;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class Student {
    private final String name;
    private final int year;
    private int points;

    public synchronized void addPoints(int reward) {
        this.points += reward;
    }

}
