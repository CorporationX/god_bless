package school.faang.task_50901;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    public int points;

    public void updatePoints(int reward) {
        points += reward;
    }
}
