package school.faang.counting_absenteeism;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class Student {
    private final String name;
    private final String faculty;
    private final int year;
}
