package school.faang.harry_potter;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
    private final String name;
    private final int year;
    private int points;

    public void addPoints(int pointsToAdd) {
        this.points += pointsToAdd;
    }
}
