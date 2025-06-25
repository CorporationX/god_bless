package school.faang.bj2_82763;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Student {
    private String name;
    private int year;
    private int points;

    public void addPoints(int points) {
        this.points += points;
    }
}