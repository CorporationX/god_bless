package faang.school.godbless.students;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Student {
    private String name;
    private String faculty;
    private int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getYear() == student.getYear() && Objects.equals(getName(), student.getName()) && Objects.equals(getFaculty(), student.getFaculty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFaculty(), getYear());
    }

    @Override
    public String toString() {
        return name + " (" + faculty + " - " + year + " year)";
    }
}
