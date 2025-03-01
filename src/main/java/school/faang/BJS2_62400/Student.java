package school.faang.BJS2_62400;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
    private final String name;
    private final int year;
    private int points;

    public void addPoints(int points) {
        this.points += points;
    }
}
