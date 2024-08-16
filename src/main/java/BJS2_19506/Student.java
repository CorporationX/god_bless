package BJS2_19506;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Student {
    private final String name;
    private final String faculty;
    private final int year;

    public Student(String name, String faculty, int year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

}
