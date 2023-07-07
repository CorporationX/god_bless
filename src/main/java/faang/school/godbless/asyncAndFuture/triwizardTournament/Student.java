package faang.school.godbless.asyncAndFuture.triwizardTournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    private int points;

    public synchronized void addPoints(int points) {
        this.points += points;
    }
}
