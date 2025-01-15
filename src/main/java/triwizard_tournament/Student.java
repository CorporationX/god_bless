package triwizard_tournament;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student {
    private final String name;
    private int year;
    private int points;

    public Student(String name, int year, int points) {
        this.name = name;
        this.year = year;
        this.points = points;
    }
}
