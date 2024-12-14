package faang.school.godbless.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@AllArgsConstructor
@ToString
@Getter
public class FacultyYearKey {
    private String faculty;
    private int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultyYearKey facultyYearKey = (FacultyYearKey) o;
        return year == facultyYearKey.year && Objects.equals(faculty, facultyYearKey.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }
}
