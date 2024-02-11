package faang.school.godbless.CountingAbsenteeism;

import java.util.Objects;

public class KeyFacultyAndYear {
    private String faculty;
    private int year;

    public KeyFacultyAndYear(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        KeyFacultyAndYear that = (KeyFacultyAndYear) object;
        return year == that.year && Objects.equals(faculty, that.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }
}
