package school.faang.task_50727;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
    public String name;
    public int year;
    public int points;

    public void addPoints(int points) {
        this.points += points;
    }
}
