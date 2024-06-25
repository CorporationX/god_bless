package faang.school.godbless.BJS2_14365;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Student {
    private String name;
    private int year;
    private int points;

    public void earnPoints(double points) {
        this.points += points;
    }
}
