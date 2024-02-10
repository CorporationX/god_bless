package faang.school.godbless.JHMCountingNoShows2005;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class FacultyYearPair {
    private String faculty;
    private int year;

    public FacultyYearPair(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }
}