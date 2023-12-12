package faang.school.godbless.task_4;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Student {
    private final String name;
    private final String faculty;
    private final String course;


    public Student(String name, String faculty, String course) {
        this.name = name;
        this.faculty = faculty;
        this.course = course;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(faculty, student.faculty) && Objects.equals(course, student.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, faculty, course);
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + "}" + '\n';
    }
}
