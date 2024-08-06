package faang.school.godbless.students;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Student {

    private String name;
    private String faculty;
    private int year;

    public String getFaculty() {
        return faculty;
    }

    public int getYear() {
        return year;
    }
}
