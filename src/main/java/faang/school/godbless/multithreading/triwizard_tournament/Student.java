package faang.school.godbless.multithreading.triwizard_tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Student {
    private String name;
    private int years;
    private int points;

    public void increasePoints(int points) {
        this.points += points;
    }
}
