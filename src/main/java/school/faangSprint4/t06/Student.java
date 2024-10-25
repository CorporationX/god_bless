package school.faangSprint4.t06;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private final String name;
    private final int year;
    private int points;

    public void addPoints(int points) {
        this.points += points;
    }
}