package faang.school.godbless.BJS2_4280;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Student {

    private static final Integer MIN_YEAR = 1;
    private static final Integer MAX_YEAR = 4;

    private String name;
    private String faculty;
    private int year;

    public Student(String name, String faculty, int year) {
        validateData(name, faculty, year);
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    private void validateData(String name, String faculty, int year) {
        if (name.isBlank() || faculty.isBlank()) {
            throw new IllegalArgumentException("Invalid data");
        }
        if (year < MIN_YEAR || year > MAX_YEAR) {
            throw new IllegalArgumentException("Invalid data");
        }
    }
}
