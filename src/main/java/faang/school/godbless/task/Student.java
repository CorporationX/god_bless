package faang.school.godbless.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@AllArgsConstructor
@ToString
@Getter
public class Student {
    private String name;
    private String faculty;
    private int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return year == student.year && Objects.equals(name, student.name) && Objects.equals(faculty, student.faculty);
    }
}
