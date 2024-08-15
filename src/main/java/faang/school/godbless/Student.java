package faang.school.godbless;

import java.util.Objects;

public class Student {

    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;

    private String name, faculty;
    private int year;

    public Student(String name, String faculty, int year) {
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
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;

        return id == student.id && Objects.equals(name, student.name);
        return year == student.year && Objects.equals(name, student.name) && Objects.equals(faculty, student.faculty);

    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
        return Objects.hash(name, faculty, year);


    @Override
    public String toString() {
      return "Student " +
                "id = " + id +
                ", name = '" + name + '\''
                ;
    }

        return name  +
                " " + faculty  +
                ", курс: " + year;
                    }
}
