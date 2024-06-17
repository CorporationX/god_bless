package faang.school.godbless;

import java.util.Objects;

public class Student {
    private String name;
    private String faculty;
    private int year;

    public String getName() {
        return this.name;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public int getYear() {
        return this.year;
    }

    public Student(String name, String faculty, int year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Student " +
                "name = " + name +
                ", faculty = " + faculty +
                ", year = " + year;
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
