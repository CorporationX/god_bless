package school.faang.BJS2_38970_TriwizardTournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    private int points;

    public void updatePoints(int points) {
        this.points += points;
    }
}
