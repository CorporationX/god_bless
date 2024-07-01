package faang.school.godbless.CountingAbsenteeism;

import java.util.Objects;

public class Student {
    private String name;
    private String faculty;
    private int year;

    public Student(String name, String faculty, int year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    public String getName() {
        return this.name;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public int getYear() {
        return this.year;
    }

    public Stage getStage() {
        return new Stage(this.getFaculty(), this.getYear());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        else if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        else {
            Student student = (Student) o;
            return this.name == student.name && this.faculty == student.faculty && this.year == student.year;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.faculty, this.year);
    }

    @Override
    public String toString() {
        return "|" + this.name + "| |" + this.faculty + "| course |" + this.year + "|";
    }
}