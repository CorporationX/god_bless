package faang.school.hashmap.countingabsenteeism;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Student {
    private String name;
    private String faculty;
    private int year;
}
