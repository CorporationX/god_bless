package faang.school.godbless.BJS2_25120;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {
    private final String name;
    private final int year;
    private int points;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
        this.points = 0;
    }
    public void addPoints(int points) {
        this.points += points;
    }
}
