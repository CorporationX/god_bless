package school.faang.magic_tournament;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Student {
    @Getter
    private final String name;
    private final int year;
    @Getter
    private int points = 0;

    public void addPoints(int points) {
        this.points = points;
    }
}
