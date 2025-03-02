package school.faang.triwizardtournament;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private final String name;
    private final int year;
    private double points;

    public void addPoints(double points) {
        this.points += points;
    }
}
