package school.faang.task_62449;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Student {
    private final String name;
    private final int year;
    private int points;

    public void addPoints(int points) {
        this.points += points;
    }
}
