package faang.school.godbless.cache.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public class Student {

    private static int counterStudents = 0;

    private final int id;
    private final String name;

    public Student(String name) {
        this.name = name;
        this.id = ++counterStudents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Student id " + id + " name " + name;
    }
}
