package school.faang;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Group {
    private final String faculty;
    private final String year;

    public Group(Student student) {
        this.faculty = student.getFaculty();
        this.year = student.getYear();
    }
    public Group(String faculty, String year) {
        this.faculty = faculty;
        this.year = year;
    }

}
