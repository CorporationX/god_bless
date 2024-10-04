package bjs2_29013;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
public class Student extends AcademicProgram {
    private final String name;

    public Student(String name, String faculty, int year) {
        super(faculty, year);
        this.name = name;
    }
}

