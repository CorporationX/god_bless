package school.faang.triwizardtournament;

import lombok.Data;

@Data
public class Student {
    private final String name;
    private final int year;
    private int points;

    public Student(String name, int year, int points) {
        this.name = name;
        this.year = year;
        this.points = points;
    }
}
