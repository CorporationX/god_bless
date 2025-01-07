package school.faang.moduleone.sprintfour.task_43582;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    private int points;

    public synchronized void addPoints(int pointsForTask) {
        points += pointsForTask;
    }
}
