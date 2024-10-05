package school.faang.HashMaps.countingAbsenteeism;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
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

    @Override
    public int hashCode() {
        return Objects.hash(name, faculty, year);
    }
}
