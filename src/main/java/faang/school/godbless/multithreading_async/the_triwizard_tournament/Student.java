package faang.school.godbless.multithreading_async.the_triwizard_tournament;

import lombok.Data;

@Data

public class Student {
    private String name;
    private int year;
    private int points;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
    }
}
