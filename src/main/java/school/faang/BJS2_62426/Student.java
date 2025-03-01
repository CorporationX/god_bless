package school.faang.BJS2_62426;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Student {

    private final String name;
    private final int year;
    private int points = 0;

    public Student(String name, int year, int points) {
        this.name = name;
        this.year = year;
        this.points = points;
    }
}
