package faang.school.godbless.async.triwizardTournament;

import lombok.Data;

@Data
public class Student {
    private String name;
    private int year;
    private int points;

    public Student(String name, int year, int points) {
        setName(name);
        setPoints(points);
        setYear(year);
    }

    public Student setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The Name cannot be null-valued or blank!");
        }

        this.name = name;
        return this;
    }

    public Student setYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("The year cannot be negative!");
        }

        this.year = year;
        return this;
    }

    public Student setPoints(int points) {
        if (points < 0) {
            throw new IllegalArgumentException("The points number cannot be negative!");
        }

        this.points = points;
        return this;
    }

    public void gainPoints(int reward) {
        setPoints(getPoints() + reward);
    }
}
