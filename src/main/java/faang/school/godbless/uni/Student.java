package faang.school.godbless.uni;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public class Student {

    private String name;
    private String faculty;
    private int year;

    @Override
    public String toString() {
        return "{Name= " + name + ", faculty=" + faculty + ", year=" + year + "}";
    }

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
