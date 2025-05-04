package school.faang.tournamentwizards;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    private final String name;
    private final int year;
    private int points;

    public synchronized void addPoints(int pointsToAdd) {
        this.points += pointsToAdd;
    }
}
