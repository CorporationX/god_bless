package school.faang.triwizardtournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public final class Student {
    private final String name;
    private final int year;
    private int points;

    public void addPoints(int points) {
        this.points += points;
    }
}
