package school.faang.threemagicians;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Student {
    private final String name;
    private final int year;
    private int points;

    public void addPoint(int point) {
        this.points += point;
    }
}