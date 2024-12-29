package school.faang.sprint_4.task_50911;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class Student {
    private final String name;
    private final int year;
    private int points;

    public void addPoints(int taskPoints) {
        if (taskPoints < 0) {
            throw new IllegalArgumentException("Task points cannot be negative!");
        }
        points += taskPoints;
    }
}
