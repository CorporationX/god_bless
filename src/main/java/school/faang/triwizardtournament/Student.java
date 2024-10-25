package school.faang.triwizardtournament;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private String name;
    private int year;
    private int points;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
    }



}
