package school.faang.task50717;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Student {
    private final String name;
    private final int year;
    private int totalPoints;

    public void addPoints(int points) {
        totalPoints += points;
    }
}
