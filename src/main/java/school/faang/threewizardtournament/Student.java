package school.faang.threewizardtournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Student {
    private final String name;
    private int year;
    private int points;

    public void addPoints(int points) {
        this.points += points;
    }
}
