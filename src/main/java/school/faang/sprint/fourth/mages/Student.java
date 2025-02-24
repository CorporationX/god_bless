package school.faang.sprint.fourth.mages;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Student {
    @NonNull
    private String name;
    private int year;
    private int points;

    public Student(@NonNull String name, int year, int points) {
        validateData(name, year, points);
        this.name = name;
        this.year = year;
        this.points = points;
    }

    private void validateData(@NonNull String name, int year, int points) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        if (year <= 0) {
            throw new IllegalArgumentException("Year must be greater than 0");
        }
        if (points < 0) {
            throw new IllegalArgumentException("Points must be greater than or equals 0");
        }
    }
}