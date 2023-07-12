package faang.school.godbless.triwizard_tournament;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student {
    private String name;
    private int year;
    private int points = 0;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
    }

}
