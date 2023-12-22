package faang.school.godbless.numberOfAbsenteeism;

import java.util.Objects;

public class Student {
    private String name;
    private String facilty;
    private int year;

    public Student(String name, String facilty, int year) {
        this.name = name;
        this.facilty = facilty;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getFacilty() {
        return facilty;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return year == student.year && Objects.equals(name, student.name) && Objects.equals(facilty, student.facilty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, facilty);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", facilty='" + facilty + '\'' +
                ", year=" + year +
                '}';
    }
}
