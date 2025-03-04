package school.faang.module1.sprint4.triwizardtournament;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private final String name;
    private final int year;
    private int points;

    public void addPoints(int reward) {
        points += reward;
    }
}