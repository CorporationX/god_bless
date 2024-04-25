package faang.school.godbless.threemagetournament;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
    private String name;
    private int year;
    private int points;

    public void incrementPoints(int points) {
        this.points += points;
    }
}
