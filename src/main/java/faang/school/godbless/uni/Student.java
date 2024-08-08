package faang.school.godbless.uni;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@ToString
@AllArgsConstructor
public class Student {
    private String name;
    private String faculty;
    private int year;
}
