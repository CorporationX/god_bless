package tournament;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Student {
    private final String name;
    private final int year;
    private int points = 0;

    public synchronized void addPoints(int pointsToAdd) {
        points += pointsToAdd;
    }
}
