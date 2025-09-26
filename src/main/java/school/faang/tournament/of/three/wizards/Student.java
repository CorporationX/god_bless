package school.faang.tournament.of.three.wizards;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Student {
    private String name;
    private int year;
    private int points;

    public void addPoints(int reward) {
        this.points += reward;
    }
}
