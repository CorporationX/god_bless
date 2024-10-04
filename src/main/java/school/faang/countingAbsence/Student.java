package school.faang.countingAbsence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Student {
    private final String name;
    private final String faculty;
    private final int year;
}
