package faang.school.godbless.triwizard_tournament;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

    private final String name;
    private final int year;
    private int points = 0;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
    }
}
