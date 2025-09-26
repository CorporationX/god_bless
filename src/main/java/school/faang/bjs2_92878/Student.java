package school.faang.bjs2_92878;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Student {
    private final String name;
    private int year;
    private int points;

    public void increasePoints(int points) {
        this.points += points;
    }
}
