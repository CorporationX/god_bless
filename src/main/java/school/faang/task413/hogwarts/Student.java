package school.faang.task413.hogwarts;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    private int points;

    public void completeTask(int reward) {
        points += reward;
    }
}
