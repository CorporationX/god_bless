package school.faang.counting.missings;

import java.util.Objects;

public class Student {

    private String name;
    private String facility;
    private int year;

    public Student(String name, String facility, int year) {
        this.name = name;
        this.facility = facility;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getFacility() {
        return facility;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return year == student.year && Objects.equals(name, student.name) && Objects.equals(facility, student.facility);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, facility, year);
    }

    @Override
    public String toString() {
        return name;
    }
}
