package faang.school.godbless.truancy;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Student {
    private String name;
    private String faculty;
    private int year;
}
