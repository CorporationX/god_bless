package faang.BJS2_74958;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Student {
    private final String name;
    private final int year;

    private int points;

    public void incrementPoints(int reward) {
        if (reward <= 0) {
            throw new IllegalArgumentException(reward + " is not a valid reward");
        }

        this.points += reward;
    }
}


