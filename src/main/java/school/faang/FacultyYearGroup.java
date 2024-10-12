package school.faang;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class FacultyYearGroup {
    private final String faculty;
    private final String year;

    public FacultyYearGroup(Student student) {
        this.faculty = student.getFaculty();
        this.year = student.getYear();
    }

    public FacultyYearGroup(String faculty, String year) {
        this.faculty = faculty;
        this.year = year;
    }

}
