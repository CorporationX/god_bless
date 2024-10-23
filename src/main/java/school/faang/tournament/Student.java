package school.faang.tournament;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Student {

    @Setter
    private String name;

    @Setter
    private int year;
    private int points;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public void addPoints(int points) {
        this.points += points;
    }
}
