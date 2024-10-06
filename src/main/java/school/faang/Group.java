package school.faang;

import lombok.Data;
import java.util.Objects;

@Data
public class Group {
    private final String faculty;
    private final String year;

    public Group(Student student) {
        this.faculty = student.getFaculty();
        this.year = student.getYear();
    }

}
