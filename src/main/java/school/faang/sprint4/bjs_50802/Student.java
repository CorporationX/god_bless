package school.faang.sprint4.bjs_50802;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Student {
    private final String name;
    private final int year;
    private volatile int points;

    public synchronized void setPoints(int reward) {
        points += reward;
    }
}
