package school.faang.triwizardtournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Student {
    private final String name;
    private int year;
    private int points;

    public void gainPoints(int reward) {
        points += reward;
    }
}
