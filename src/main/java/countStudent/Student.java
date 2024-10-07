package countStudent;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@Getter
@EqualsAndHashCode
@ToString
public class Student {
    public static final int FIRST_COURSE = 1;
    public static final int LAST_COURSE = 7;

    private String name;
    private String faculty;
    private int year;

    public Student(String name, String faculty, int year) {
        checkExp(name, faculty, year);

        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    public void checkExp(String name, String faculty, int year) {
        if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("Пустое имя");
        } else if (faculty.isEmpty() || faculty.isBlank()) {
            throw new IllegalArgumentException("Пустой факультет");
        } else if (year < FIRST_COURSE || year > LAST_COURSE) {
            throw new IllegalArgumentException("Недопустимый возраст");
        }
    }

}
