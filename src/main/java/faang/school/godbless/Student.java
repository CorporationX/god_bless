package src.main.java.faang.school.godbless;

import java.util.Objects;

public class Student {
    String name;
    String faculty;
    int year;

    Student(String name, String faculty, int year){
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return getYear() == student.getYear() && Objects.equals(getName(), student.getName()) && Objects.equals(getFaculty(), student.getFaculty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFaculty(), getYear());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", year=" + year +
                '}';
    }
}
