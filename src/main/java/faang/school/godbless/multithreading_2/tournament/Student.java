package faang.school.godbless.multithreading_2.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Student {
    private String name;
    private int year;
    private int points;

    public void increasePoints(int points) {
        this.points += points;
    }
}
