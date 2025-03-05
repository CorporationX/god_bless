package school.faang.triwizardtournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
    private final String name;
    private final int year;
    private int points;

    public void addPoints(int reward) {
        points += reward;
    }
}
