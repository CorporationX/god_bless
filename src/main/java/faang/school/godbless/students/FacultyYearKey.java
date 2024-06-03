package faang.school.godbless.students;

import java.util.Objects;

public record FacultyYearKey(String faculty, int year) {

    public FacultyYearKey(String faculty, int year) {
        this.faculty = Objects.requireNonNull(faculty.trim());
        this.year = year;
    }
}