package absence;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Student {
    private final String name;
    private final String faculty;
    private final int year;

    public Student(String name, String faculty, int year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return year == student.year && Objects.equals(faculty, student.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }

    public boolean equalsByAllFields(Student student) {
        return this.name.equals(student.name) && this.faculty.equals(student.faculty) && this.year == student.year;
    }
}
