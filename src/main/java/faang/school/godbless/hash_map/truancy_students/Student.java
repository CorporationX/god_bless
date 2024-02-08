package faang.school.godbless.hash_map.truancy_students;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
public class Student {
    private String name;
    private String faculty;
    private int year;
}
