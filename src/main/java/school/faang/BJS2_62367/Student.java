package school.faang.BJS2_62367;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Student {
    private final String name;
    private final int year;
    private int points;

    public synchronized void addPoints(int reward) {
        this.points += reward;
    }
}
