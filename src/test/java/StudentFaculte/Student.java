package StudentFaculte;

import java.util.Objects;

public class Student {
    private String name;
    private Faculte faculte;

    public Student(String name, Faculte faculte) {
        this.name = name;
        this.faculte = faculte;
    }

    public String getName() {
        return name;
    }

    public Faculte getFaculte() {
        return faculte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(faculte, student.faculte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, faculte);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", faculte=" + faculte +
                '}';
    }
}
