package faang.school.godbless.Task8;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;


@Getter
@EqualsAndHashCode
@ToString

public class Student {

    private String name;
    private String faculty;
    private int year;

    public Student(String name, String faculty, int year) {
        if (name.isBlank() || faculty.isBlank() || year < 1) {
            throw new IllegalArgumentException("check arguments");
        } else {
            this.name = name;
            this.faculty = faculty;
            this.year = year;
        }
    }

    public void addToList(List<Student> students) {
        students.add(this);
    }

}
