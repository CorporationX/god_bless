package wizardtournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Student {
    private String name;
    private int year;
    private int points;

    public synchronized void addPoints(int points) {
        this.points += points;
    }
}
