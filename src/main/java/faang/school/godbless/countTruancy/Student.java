package faang.school.godbless.countTruancy;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Student {
    private String name;
    private String faculty;
    private int year;
}
