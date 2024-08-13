package faang.school.godbless.students;

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
        return name + " (" + faculty + " - " + year + " year)";
    }
}
