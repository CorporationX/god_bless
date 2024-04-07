package faang.school.godbless.university;

import lombok.ToString;

import java.util.Objects;

@ToString(includeFieldNames=true)
public class GroupOfStudents {
    private String faculty;
    private int year;

    public GroupOfStudents(String faculty, int year) {
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
        GroupOfStudents that = (GroupOfStudents) o;
        return year == that.year && Objects.equals(faculty, that.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }

}
