package faang.school.godbless.countabsent;

import java.util.Objects;

public class StudentStream {
    private String faculty;
    private Integer year;

    public StudentStream(String faculty, Integer year) {
        this.faculty = faculty;
        this.year = year;
    }

    @Override
    public String toString() {
        return "StudentStream {" +
                "faculty='" + faculty + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentStream that = (StudentStream) o;
        return Objects.equals(faculty, that.faculty) && Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }
}
