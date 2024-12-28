package school.faang.task_50901;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
    private final String name;
    private final int year;
    private int points;

    public void updatePoints(int reward) {
        points += reward;
    }
}
