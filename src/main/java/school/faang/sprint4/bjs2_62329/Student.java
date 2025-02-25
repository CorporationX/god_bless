package school.faang.sprint4.bjs2_62329;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Student {
    private final String name;
    private final int year;
    private int points;

    public Student(@NonNull String name, int year, int points) {
        this.name = name;
        this.year = year;
        this.points = points;
    }

    public void addPoints(int points) {
        this.points += points;
    }
}
