package faang.school.godbless.counting_absences;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Student {
    private final String name;
    private String faculty;
    private int year;
}
