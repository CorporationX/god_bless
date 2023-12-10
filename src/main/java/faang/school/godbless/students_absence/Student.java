package faang.school.godbless.students_absence;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    private String name;
    private String faculty;
    private int year;

    @Override
    public String toString() {
        return "Name: " + name +
                ", Faculty: " + faculty +
                ", Year: " + year;
    }
}
