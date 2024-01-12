package faang.school.godbless.multi_asyn.task4wizards;

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
