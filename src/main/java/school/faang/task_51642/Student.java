package school.faang.task_51642;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Student {
    private final String nameStudent;
    private final int year;
    @Getter
    private int points;

    public void addPoints(int points) {
        this.points += points;
    }

}
