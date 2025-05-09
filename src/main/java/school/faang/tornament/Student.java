package school.faang.tornament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Student {
    private final String name;
    private final int year;
    private int points;

    public void addPoints(int points) {
        this.points += points;
    }
}
