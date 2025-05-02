package school.faang.bjs274940;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Student {
    private final String name;
    private int year;
    private int points = 0;

    public synchronized void addPoints(int points) {
        this.points += points;
    }
}
