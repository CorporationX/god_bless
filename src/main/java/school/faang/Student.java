package school.faang;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Student {
    private final String name;
    private final String faculty;
    private final String year;

    public Student(String name, String faculty, String year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

}
