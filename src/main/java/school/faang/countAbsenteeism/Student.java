package school.faang.countAbsenteeism;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private String faculty;
    private Integer year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(faculty, student.faculty) && Objects.equals(year, student.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, faculty, year);
    }
}
