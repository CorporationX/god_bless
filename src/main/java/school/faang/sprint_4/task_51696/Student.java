package school.faang.sprint_4.task_51696;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Student {
    private String nameOfStudent;
    private int year;
    private int points;

    public void addPoints(int points) {
        this.points += points;
    }
}
