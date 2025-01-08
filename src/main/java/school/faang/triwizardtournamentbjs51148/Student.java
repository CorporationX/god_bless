package school.faang.triwizardtournamentbjs51148;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Student {
    private String name;
    private int year;
    private int points;

    public void addPoints(int points) {
        if (points < 0) {
            throw new IllegalArgumentException("Points must be non-negative");
        }
        this.points += points;
    }
}
