package BJS2_19506;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
public class FacultyYearPair {
    private final String faculty;
    private final int year;

    public FacultyYearPair(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultyYearPair facultyYearPair = (FacultyYearPair) o;
        return getYear() == facultyYearPair.getYear() && Objects.equals(getFaculty(), facultyYearPair.getFaculty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFaculty(), getYear());
    }
}
