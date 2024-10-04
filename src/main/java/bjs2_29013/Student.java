package bjs2_29013;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Student {
    private final String name;
    private AcademicProgram academicProgram;

    public Student(String name, AcademicProgram academicProgram) {
        this.name = name;
        this.academicProgram = academicProgram;
    }

    public Student(String name, String faculty, int year) {
        this.name = name;
        academicProgram = new AcademicProgram(faculty, year);
    }
}

