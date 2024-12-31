package school.faang.bjs251742;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Student {
    private final String name;
    private int year;
    private int points;

    public void addPoints(int points) {
        this.points += points;
    }
}
