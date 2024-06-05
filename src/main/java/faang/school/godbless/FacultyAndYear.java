package faang.school.godbless;

import java.util.Objects;

public class FacultyAndYear {
    private String faculty;
    private Integer year;

    public FacultyAndYear(String faculty, Integer year){
        this.faculty = faculty;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultyAndYear that = (FacultyAndYear) o;
        return Objects.equals(faculty, that.faculty) && Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }

    public String getFaculty() {
        return faculty;
    }

    public Integer getYear() {
        return year;
    }
}