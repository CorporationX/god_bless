package school.faang.BJS2_32549;

import lombok.Data;
import lombok.Getter;

import java.util.Objects;

@Data
@Getter
public class Student {
    private String name;
    private String faculty;
    private int year;

    public Student(String name, String faculty, int year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }
}

