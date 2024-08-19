package faang.school.godbless.countAbsences;

import lombok.EqualsAndHashCode;


@EqualsAndHashCode
public class PairFacultyYearKey {
    private final String faculty;
    private final Integer year;


    public PairFacultyYearKey(String faculty, Integer year) {
        this.faculty = faculty;
        this.year = year;
    }
}