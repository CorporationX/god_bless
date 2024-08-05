package faang.school.godbless.counting_absenteeism;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Student {
    private String name;
    private String faculty;
    private int year;
}
