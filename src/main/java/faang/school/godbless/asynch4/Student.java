package faang.school.godbless.asynch4;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Student {
    private final String name;
    private final int year;
    @Setter
    private int points;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
        this.points = 0;
    }
}
