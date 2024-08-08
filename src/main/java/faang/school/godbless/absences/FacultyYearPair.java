package faang.school.godbless.absences;

import java.util.Objects;

public class FacultyYearPair {
    private String faculty;
    private int year;

    public FacultyYearPair(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
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
        FacultyYearPair that = (FacultyYearPair) o;
        return year == that.year && Objects.equals(faculty, that.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }

    @Override
    public String toString() {
        return faculty + " - " + year;
    }
}
