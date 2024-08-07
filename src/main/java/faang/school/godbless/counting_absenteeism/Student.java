package faang.school.godbless.counting_absenteeism;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Student {
    private String name;
    private String faculty;
    private int year;
}
