package faang.school.godbless.multithreading_async.task_5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Student {
    private final String name;
    private final Year year;
    private int points;

    public void addPoints(int points) {
        this.points += points;
    }
}
