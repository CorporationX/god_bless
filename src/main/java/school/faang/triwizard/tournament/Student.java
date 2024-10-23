package school.faang.triwizard.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    private double points;

    public void increasePoints(double points) {
        this.points += points;
    }
}
