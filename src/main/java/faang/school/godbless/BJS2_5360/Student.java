package faang.school.godbless.BJS2_5360;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private String faculty;
    private int year;

    public String getYearFacultyKey() {
        return getFaculty() + "-" + getYear();
    }
}
