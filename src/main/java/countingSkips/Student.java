package countingSkips;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;

@Getter
@EqualsAndHashCode
public class Student {
    private String name;
    private String faculty;
    private int year;

    public Student(String name, String faculty, int year) {
        studentValidation(name, faculty, year);
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    private void studentValidation(String name, String faculty, int year) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("имя студента не должно быть пустым");
        } else if (faculty == null || faculty.isEmpty()) {
            throw new IllegalArgumentException("факультет не должен быть пустым");
        } else if (year < 1) {
            throw new IllegalArgumentException("курс не может быть меньше 1");
        }

    }

}
