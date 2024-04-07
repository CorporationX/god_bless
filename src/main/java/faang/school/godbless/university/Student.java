package faang.school.godbless.university;

import lombok.ToString;

import java.util.Objects;

@ToString(includeFieldNames=true)
public class Student {
    private String name;
    private String faculty;
    private int year;
    private GroupOfStudents groupOfStudents;

    public Student(String name, String faculty, int year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
        this.groupOfStudents = new GroupOfStudents(faculty, year);
    }

    public GroupOfStudents getFacultyAndYear() {
        return groupOfStudents;
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
